package com.sfr.practicas_signlab.detallepost.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sfr.practicas_signlab.api.Models.Comment;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.databinding.ActivityDetallepostBinding;
import com.sfr.practicas_signlab.detallepost.adapter.CommentsAdapter;
import com.sfr.practicas_signlab.detallepost.presenter.DetallePostPresenter;
import com.sfr.practicas_signlab.detalleusuario.view.DetalleUsuario;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import java.util.ArrayList;
import javax.inject.Inject;

public class DetallePostActivity extends AppCompatActivity implements DetallePostView, SwipeRefreshLayout.OnRefreshListener {
    private ActivityDetallepostBinding binding;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private CommentsAdapter commentsAdapter;
    private Post post;
    @Inject
    DetallePostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetallepostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Detalle de post");

        post = getIntent().getParcelableExtra("post");

        binding.textViewTitutlo.setText(post.getTitle());
        binding.textViewPost.setText(post.getBody());

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.onCommentsFetched(Integer.parseInt(post.getId()));

    }

    @Override
    public void ShowComments(ArrayList<Comment> comments) {
        commentsAdapter = new CommentsAdapter(comments);
        recyclerView.setAdapter(commentsAdapter);
        commentsAdapter.notifyDataSetChanged();

    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Manejar el evento de hacer clic en el botón de retroceso
                startActivity(new Intent(this, DetalleUsuario.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRefresh() {
        presenter.onCommentsFetched(Integer.parseInt(post.getId()));
        binding.swiperefresh.setRefreshing(false);

    }

}
