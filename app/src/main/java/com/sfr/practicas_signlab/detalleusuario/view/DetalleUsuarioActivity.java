package com.sfr.practicas_signlab.detalleusuario.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sfr.practicas_signlab.R;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.crearpost.view.CrearPostActivity;
import com.sfr.practicas_signlab.databinding.ActivityDetalleusuarioBinding;
import com.sfr.practicas_signlab.detallepost.view.DetallePostActivity;
import com.sfr.practicas_signlab.detalleusuario.adapter.PostsAdapter;
import com.sfr.practicas_signlab.detalleusuario.adapter.TodosAdapter;
import com.sfr.practicas_signlab.detalleusuario.presenter.DetalleUsuarioPresenter;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.editarpost.view.EditarPostActivity;
import com.sfr.practicas_signlab.home.view.HomeActivity;
import java.util.ArrayList;
import javax.inject.Inject;

public class DetalleUsuarioActivity extends AppCompatActivity implements PostsAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, DetalleUsuarioView, TodosAdapter.OnTodoCheckedChangeListener, PostsAdapter.OnImageClickListener {
    private ActivityDetalleusuarioBinding binding;
    private User user;
    private RecyclerView recyclerViewPosts;
    private RecyclerView recyclerViewTodos;
    private TodosAdapter tareasAdapter;
    private PostsAdapter postsAdapter;
    private ActionBar actionBar;
    @Inject
    DetalleUsuarioPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleusuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Detalle de usuario");

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
        presenter.onTodosFetched(user.getId());

    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
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
        tareasAdapter = new TodosAdapter(this, todos);
        recyclerViewTodos.setAdapter(tareasAdapter);
        tareasAdapter.notifyDataSetChanged();

    }

    @Override
    public void showPosts(ArrayList<Post> posts) {
        postsAdapter = new PostsAdapter(posts, this, this);
        recyclerViewPosts.setAdapter(postsAdapter);
        postsAdapter.notifyDataSetChanged();

    }

    @Override
    public void onTodoCheckedChanged(Todo todo) {
        // Actualizar el estado de completado de la tarea en la lista de tareas según sea necesario
        todo.setCompleted(!todo.isCompleted());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(this, HomeActivity.class));
            return super.onOptionsItemSelected(item);

        }

        if (id == R.id.add){
            Intent intent = new Intent(this, CrearPostActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);

            return super.onOptionsItemSelected(item);

        }
        /*switch (item.getItemId()) {
            case android.R.id.home:
                // Manejar el evento de hacer clic en el botón de retroceso
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            case R.id.add:
                startActivity(new Intent(this, CrearPostActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Post post) {
        Intent intent = new Intent(this, DetallePostActivity.class);
        intent.putExtra("post", post);
        startActivity(intent);

    }

    @Override
    public void onImageClick(Post post) {
        Intent intent = new Intent(this, EditarPostActivity.class);
        intent.putExtra("post", post);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_usuario, menu);
        return true;
    }

}