package com.sfr.practicas_signlab.editarpost.view;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.practicas_signlab.databinding.ActivityEditarpostBinding;

public class EditarPostActivity extends AppCompatActivity {
    private ActivityEditarpostBinding binding;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditarpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //initInjection();

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Edición de post");

    }

   /* private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }*/

}
