package com.sfr.practicas_signlab.di.appComponent;

import com.sfr.practicas_signlab.MainActivity;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.views.AlbunesFragment;
import com.sfr.practicas_signlab.views.HomeActivity;
import com.sfr.practicas_signlab.views.LoginActivity;
import com.sfr.practicas_signlab.views.PortadasFragment;
import com.sfr.practicas_signlab.views.UsuariosFragment;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    void inject(MainActivity mainactivity);

    void inject(LoginActivity loginactivity);

    void inject(HomeActivity homeactivity);

    void inject(AlbunesFragment albunesfragment);

    void inject(PortadasFragment portadasfragment);

    void inject(UsuariosFragment usuariosfragment);
}