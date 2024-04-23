package com.sfr.practicas_signlab.editarpost.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.databinding.ActivityEditarpostBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.editarpost.presenter.EditarPostPresenter;

import javax.inject.Inject;

import retrofit2.Response;

public class EditarPostActivity extends AppCompatActivity implements EditarPostView {
    private ActivityEditarpostBinding binding;
    private ActionBar actionBar;
    private Post post;
    @Inject
    EditarPostPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditarpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Edición de post");

        post = getIntent().getParcelableExtra("post");

        setFill(post);
    }

    private void setFill(Post post) {
        binding.editTextTitle.setText(post.getTitle());
        binding.editTextBody.setText(post.getBody());
    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    public void onGuardar(View view){
        presenter.onGuardar(post.getId(), post.getId(), binding.editTextTitle.getText().toString(), binding.editTextBody.getText().toString(), post.getUserId());
    }

    @Override
    public void showAnswer(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowSuccessData(Post response) {
        setFill(response);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }
}
