package com.sfr.practicas_signlab.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.practicas_signlab.databinding.ActivityLoginBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.presenters.LoginPresenterInt;

import java.util.Objects;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginViewInt {
    private ActivityLoginBinding binding;
    @Inject
    LoginPresenterInt presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();
        binding.buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = Objects.requireNonNull(binding.editTextUsername.getText()).toString();
                String password = Objects.requireNonNull(binding.editTextPassword.getText()).toString();
                presenter.checkCredentials(username, password);
            }
        });
    }
    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }
    @Override
    public void onLoginCheck(String mensaje, boolean IsLoggedIn) {
        if (IsLoggedIn) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        } else {
            // Mostrar un mensaje de error al usuario o realizar alguna otra acción
            Toast.makeText(this, "Error: credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }
}