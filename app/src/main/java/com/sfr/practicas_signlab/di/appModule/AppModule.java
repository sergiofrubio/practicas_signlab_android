package com.sfr.practicas_signlab.di.appModule;

import android.content.Context;
import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.MainActivity;
import com.sfr.practicas_signlab.interactors.AlbunesInteractorInt;
import com.sfr.practicas_signlab.interactors.LoginInteractor;
import com.sfr.practicas_signlab.interactors.LoginInteractorInt;
import com.sfr.practicas_signlab.interactors.PortadasInteractorInt;
import com.sfr.practicas_signlab.interactors.UsuariosInteractor;
import com.sfr.practicas_signlab.interactors.UsuariosInteractorInt;
import com.sfr.practicas_signlab.presenters.AlbunesPresenter;
import com.sfr.practicas_signlab.presenters.AlbunesPresenterInt;
import com.sfr.practicas_signlab.presenters.LoginPresenterInt;
import com.sfr.practicas_signlab.presenters.PortadasPresenter;
import com.sfr.practicas_signlab.presenters.PortadasPresenterInt;
import com.sfr.practicas_signlab.presenters.UsuariosPresenter;
import com.sfr.practicas_signlab.presenters.UsuariosPresenterInt;
import com.sfr.practicas_signlab.views.AlbunesFragment;
import com.sfr.practicas_signlab.views.AlbunesFragmentInt;
import com.sfr.practicas_signlab.views.LoginViewInt;
import com.sfr.practicas_signlab.MainViewInt;
import com.sfr.practicas_signlab.presenters.LoginPresenter;
import com.sfr.practicas_signlab.views.HomeActivity;
import com.sfr.practicas_signlab.views.LoginActivity;
import com.sfr.practicas_signlab.views.PortadasFragment;
import com.sfr.practicas_signlab.views.PortadasFragmentInt;
import com.sfr.practicas_signlab.views.UsuariosFragment;
import com.sfr.practicas_signlab.views.UsuariosFragmentInt;
import dagger.Module;
import dagger.Provides;

@Module(includes = {SharedPreferencesModule.class, ConnectionModule.class})
public class AppModule {
    private AlbunesFragment albunesfragment;
    private PortadasFragment portadasfragment;
    private LoginActivity loginactivity;
    private MainActivity mainactivity;
    private HomeActivity homeactivity;
    private UsuariosFragment usuariosfragment;
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

    public AppModule(UsuariosFragment usuariosfragment, Context context) {
        this.usuariosfragment = usuariosfragment;
        this.context = context;
    }

    public AppModule(AlbunesFragment albunesfragment, Context context) {
        this.albunesfragment = albunesfragment;
        this.context = context;
    }

    public AppModule(PortadasFragment portadasfragment, Context context) {
        this.portadasfragment = portadasfragment;
        this.context = context;
    }


    // Un método de estos por cada vista
    @Nullable
    @Provides
    public LoginViewInt loginactivity() {
        if(loginactivity != null){
            return loginactivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public MainViewInt mainactivity() {
        if(mainactivity != null){
            return mainactivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public UsuariosFragmentInt usuariosfragment() {
        if (usuariosfragment != null){
            return usuariosfragment;
        }

        return null;
    }

    @Nullable
    @Provides
    public AlbunesFragmentInt albunesfragment() {
        if(albunesfragment!=null){
            return albunesfragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public PortadasFragmentInt portadasfragment() {
        if(portadasfragment!=null){
            return portadasfragment;

        }
        return null;
    }

    @Provides
    public LoginPresenterInt providesLoginPresenterImpl(LoginPresenter presenter) {
        return presenter;
    }

    @Provides
    public UsuariosPresenterInt providesUsuariosFragmentInt(UsuariosPresenter presenter){
        return presenter;
    }

    @Provides
    public PortadasPresenterInt providesPortadasFragmentInt(PortadasPresenter presenter){
        return presenter;
    }

    @Provides
    public AlbunesPresenterInt providesAlbunesFragmentInt(AlbunesPresenter presenter){
        return presenter;
    }

    @Provides
    public LoginInteractorInt providesLoginInteractorImpl(LoginInteractor interactor) {
        return interactor;
    }

    @Provides
    public UsuariosInteractorInt providesUsuariosInteractorInt(UsuariosInteractor interactor){
        return interactor;
    }

    @Provides
    public PortadasInteractorInt providesPortadasInteractorInt(PortadasInteractorInt interactor){
        return interactor;
    }

    @Provides
    public AlbunesInteractorInt providesAlbunesInteractorInt(AlbunesInteractorInt interactor){
        return interactor;
    }

}
