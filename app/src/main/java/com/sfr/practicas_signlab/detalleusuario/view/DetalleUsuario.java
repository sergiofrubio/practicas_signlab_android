package com.sfr.practicas_signlab.detalleusuario.view;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationBarView;
import com.sfr.practicas_signlab.R;
import com.sfr.practicas_signlab.albunes.view.AlbunesFragmentImpl;
import com.sfr.practicas_signlab.databinding.ActivityDetalleusuarioBinding;
import com.sfr.practicas_signlab.databinding.ActivityHomeBinding;
import com.sfr.practicas_signlab.di.appComponent.AppComponent;
import com.sfr.practicas_signlab.di.appComponent.DaggerAppComponent;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.portadas.view.PortadasFragmentImpl;
import com.sfr.practicas_signlab.usuarios.view.UsuariosFragmentImpl;

public class DetalleUsuario extends AppCompatActivity {
    private ActivityDetalleusuarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleusuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //initInjection();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container,fragment);
        fragmentTransaction.commit();
    }
/*
    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }
*/
}