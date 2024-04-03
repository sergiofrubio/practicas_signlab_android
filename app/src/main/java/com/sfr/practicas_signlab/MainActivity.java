package com.sfr.practicas_signlab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.sfr.practicas_signlab.databinding.ActivityMainBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.presenters.LoginPresenterInt;
import com.sfr.practicas_signlab.views.HomeActivity;
import com.sfr.practicas_signlab.views.LoginActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainViewInt {
    private ActivityMainBinding binding;

    @Inject
    LoginPresenterInt presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();
        presenter.obtenerCredenciales();
    }

    private void initInjection() {
       AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }


    @Override
    public void onReedirigiraLoginActivity() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onReedirigiraHomeActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();
    }

}