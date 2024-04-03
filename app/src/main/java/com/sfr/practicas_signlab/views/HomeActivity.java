package com.sfr.practicas_signlab.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationBarView;
import com.sfr.practicas_signlab.R;
import com.sfr.practicas_signlab.databinding.ActivityHomeBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;

import java.lang.reflect.Array;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new UsuariosFragment());
        binding.bottomNavigation.setOnItemSelectedListener(this);
        initInjection();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container,fragment);
        fragmentTransaction.commit();
    }
    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int IdBotonPulsado = menuItem.getItemId();

        int[] optionMenu = new int[binding.bottomNavigation.getMenu().size()];
        for (int i=0; i<binding.bottomNavigation.getMenu().size(); i++) {
            optionMenu[i]=binding.bottomNavigation.getMenu().getItem(i).getItemId();
        }

        if(optionMenu[0]==IdBotonPulsado){
            replaceFragment(new UsuariosFragment());
        }

        if(optionMenu[1]==IdBotonPulsado) {
            replaceFragment(new AlbunesFragment());
        }

        if (optionMenu[2]==IdBotonPulsado) {
            replaceFragment(new PortadasFragment());
        }

        return true;
    }
}