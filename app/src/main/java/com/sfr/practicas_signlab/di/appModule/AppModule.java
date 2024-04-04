package com.sfr.practicas_signlab.di.appModule;

import android.content.Context;
import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.main.view.MainActivity;
import com.sfr.practicas_signlab.main.view.MainView;
import com.sfr.practicas_signlab.albunes.interactor.AlbunesInteractorImpl;
import com.sfr.practicas_signlab.albunes.interactor.AlbunesInteractor;
import com.sfr.practicas_signlab.login.interactor.LoginInteractorImpl;
import com.sfr.practicas_signlab.login.interactor.LoginInteractor;
import com.sfr.practicas_signlab.portadas.interactor.PortadasInteractorImpl;
import com.sfr.practicas_signlab.portadas.interactor.PortadasInteractor;
import com.sfr.practicas_signlab.usuarios.interactor.UsuariosInteractorImpl;
import com.sfr.practicas_signlab.usuarios.interactor.UsuariosInteractor;
import com.sfr.practicas_signlab.albunes.presenter.AlbunesPresenter;
import com.sfr.practicas_signlab.albunes.presenter.AlbunesPresenterImpl;
import com.sfr.practicas_signlab.login.presenter.LoginPresenter;
import com.sfr.practicas_signlab.portadas.presenter.PortadasPresenter;
import com.sfr.practicas_signlab.portadas.presenter.PortadasPresenterImpl;
import com.sfr.practicas_signlab.usuarios.presenter.UsuariosPresenterImpl;
import com.sfr.practicas_signlab.usuarios.presenter.UsuariosPresenter;
import com.sfr.practicas_signlab.albunes.view.AlbunesFragmentImpl;
import com.sfr.practicas_signlab.albunes.view.AlbunesFragment;
import com.sfr.practicas_signlab.login.view.LoginView;
import com.sfr.practicas_signlab.login.presenter.LoginPresenterImpl;
import com.sfr.practicas_signlab.home.view.HomeActivity;
import com.sfr.practicas_signlab.login.view.LoginActivity;
import com.sfr.practicas_signlab.portadas.view.PortadasFragment;
import com.sfr.practicas_signlab.portadas.view.PortadasFragmentImpl;
import com.sfr.practicas_signlab.usuarios.view.UsuariosFragmentImpl;
import com.sfr.practicas_signlab.usuarios.view.UsuariosFragment;
import dagger.Module;
import dagger.Provides;

@Module(includes = {SharedPreferencesModule.class, ConnectionModule.class})
public class AppModule {
    private AlbunesFragmentImpl albunesfragment;
    private PortadasFragmentImpl portadasfragment;
    private LoginActivity loginactivity;
    private MainActivity mainactivity;
    private HomeActivity homeactivity;
    private UsuariosFragmentImpl usuariosfragment;
    private Context context;


    // Un constructor por cada vista
    public AppModule(){}

    public AppModule(MainActivity mainactivity, Context context) {
        this.mainactivity = mainactivity;
        this.context = context;

    }
    public AppModule(LoginActivity loginactivity, Context context) {
        this.loginactivity = loginactivity;
        this.context = context;

    }

    public AppModule(HomeActivity homeactivity, Context context) {
        this.homeactivity = homeactivity;
        this.context = context;

    }

    public AppModule(UsuariosFragmentImpl usuariosfragment, Context context) {
        this.usuariosfragment = usuariosfragment;
        this.context = context;
    }

    public AppModule(AlbunesFragmentImpl albunesfragment, Context context) {
        this.albunesfragment = albunesfragment;
        this.context = context;
    }

    public AppModule(PortadasFragmentImpl portadasfragment, Context context) {
        this.portadasfragment = portadasfragment;
        this.context = context;
    }


    // Un método de estos por cada vista
    @Nullable
    @Provides
    public LoginView loginactivity() {
        if(loginactivity != null){
            return loginactivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public MainView mainactivity() {
        if(mainactivity != null){
            return mainactivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public UsuariosFragment usuariosfragment() {
        if (usuariosfragment != null){
            return usuariosfragment;
        }

        return null;
    }

    @Nullable
    @Provides
    public AlbunesFragment albunesfragment() {
        if(albunesfragment!=null){
            return albunesfragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public PortadasFragment portadasfragment() {
        if(portadasfragment!=null){
            return portadasfragment;

        }
        return null;
    }

    @Provides
    public LoginPresenter providesLoginPresenterImpl(LoginPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public UsuariosPresenter providesUsuariosPresenterImpl(UsuariosPresenterImpl presenter){
        return presenter;
    }

    @Provides
    public PortadasPresenter providesPortadasPresenterImpl(PortadasPresenterImpl presenter){
        return presenter;
    }

    @Provides
    public AlbunesPresenter providesAlbunesPresenterImpl(AlbunesPresenterImpl presenter){
        return presenter;
    }

    @Provides
    public LoginInteractor providesLoginInteractorImpl(LoginInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public UsuariosInteractor providesUsuariosInteractorImpl(UsuariosInteractorImpl interactor){
        return interactor;
    }

    @Provides
    public PortadasInteractor providesPortadasInteractorImpl(PortadasInteractorImpl interactor){
        return interactor;
    }

    @Provides
    public AlbunesInteractor providesAlbunesInteractorImpl(AlbunesInteractorImpl interactor){
        return interactor;
    }

}
