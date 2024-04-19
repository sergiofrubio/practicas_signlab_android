package com.sfr.practicas_signlab.editarpost.view;

import android.os.Bundle;
import android.view.View;

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
        presenter.onGuardar(binding.editTextTitle.getText().toString(), binding.editTextBody.getText().toString());
    }

}
