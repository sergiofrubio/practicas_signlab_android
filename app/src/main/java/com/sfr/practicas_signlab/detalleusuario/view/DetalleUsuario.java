package com.sfr.practicas_signlab.detalleusuario.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.databinding.ActivityDetalleusuarioBinding;
import com.sfr.practicas_signlab.detalleusuario.adapter.PostsAdapter;
import com.sfr.practicas_signlab.detalleusuario.adapter.TodosAdapter;
import com.sfr.practicas_signlab.detalleusuario.presenter.DetalleUsuarioPresenter;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.home.view.HomeActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class DetalleUsuario extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, DetalleUsuarioView {
    private ActivityDetalleusuarioBinding binding;
    private User user;
    private RecyclerView recyclerViewPosts;
    private RecyclerView recyclerViewTodos;
    private TodosAdapter tareasAdapter;
    private PostsAdapter postsAdapter;
    @Inject
    DetalleUsuarioPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleusuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        // Recibir el objeto User pasado desde UsuariosFragmentImpl
        user = getIntent().getParcelableExtra("user");

        recyclerViewPosts = binding.recyclerViewposts;
        recyclerViewTodos = binding.recyclerViewtodos;
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTodos.setLayoutManager(new LinearLayoutManager(this));

        binding.textViewUsername.setText(user.getName());
        binding.swiperefreshposts.setOnRefreshListener(this);
        binding.swiperefreshtodos.setOnRefreshListener(this);

        presenter.onPostsFetched(user.getId());
        postsAdapter = new PostsAdapter();
        recyclerViewPosts.setAdapter(postsAdapter);

        presenter.onTodosFetched(user.getId());
        tareasAdapter = new TodosAdapter();
        recyclerViewTodos.setAdapter(tareasAdapter);

    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    public void onGoBack(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onRefresh() {
        if(binding.swiperefreshposts.isRefreshing()){
            binding.swiperefreshposts.setRefreshing(false);
        }

        if (binding.swiperefreshtodos.isRefreshing()) {
            binding.swiperefreshtodos.setRefreshing(false);
        }

    }

    @Override
    public void showTodos(ArrayList<Todo> todos) {
        Log.i("infotodos", String.valueOf(todos));
        tareasAdapter.setTodos(todos);
        tareasAdapter.notifyDataSetChanged();

    }

    @Override
    public void showPosts(ArrayList<Post> posts) {
        Log.i("infoposts", String.valueOf(posts));
        postsAdapter.setPosts(posts);
        postsAdapter.notifyDataSetChanged();

    }
}