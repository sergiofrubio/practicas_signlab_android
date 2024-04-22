package com.sfr.practicas_signlab.crearpost.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.crearpost.presenter.CrearPostPresenter;
import com.sfr.practicas_signlab.databinding.ActivityCrearpostBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import javax.inject.Inject;

public class CrearPostActivity extends AppCompatActivity implements CrearPostView {
    private ActivityCrearpostBinding binding;
    private ActionBar actionBar;
    private Post post;
    private User user;
    @Inject
    CrearPostPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crear post");

        user = getIntent().getParcelableExtra("user");


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
        presenter.onGuardar(user.getId(), binding.editTextTitle.getText().toString(), binding.editTextBody.getText().toString());
    }

    @Override
    public void showAnswer(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowSuccessData(Post response) {
        setFill(response);
    }

}
