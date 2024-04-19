package com.sfr.practicas_signlab.di.appComponent;

import com.sfr.practicas_signlab.detallepost.view.DetallePostActivity;
import com.sfr.practicas_signlab.detalleusuario.view.DetalleUsuario;
import com.sfr.practicas_signlab.editarpost.view.EditarPostActivity;
import com.sfr.practicas_signlab.main.view.MainActivity;
import com.sfr.practicas_signlab.di.appModule.AppModule;
import com.sfr.practicas_signlab.di.appModule.SharedPreferencesModule;
import com.sfr.practicas_signlab.albunes.view.AlbunesFragmentImpl;
import com.sfr.practicas_signlab.home.view.HomeActivity;
import com.sfr.practicas_signlab.login.view.LoginActivity;
import com.sfr.practicas_signlab.portadas.view.PortadasFragmentImpl;
import com.sfr.practicas_signlab.usuarios.view.UsuariosFragmentImpl;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    void inject(MainActivity mainactivity);
    void inject(LoginActivity loginactivity);
    void inject(HomeActivity homeactivity);
    void inject(AlbunesFragmentImpl albunesfragment);
    void inject(PortadasFragmentImpl portadasfragment);
    void inject(UsuariosFragmentImpl usuariosfragment);
    void inject(DetalleUsuario detalleusuario);
    void inject(DetallePostActivity detallePostActivity);
    void inject(EditarPostActivity editarPostActivity);
}