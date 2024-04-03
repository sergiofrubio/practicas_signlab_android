package com.sfr.practicas_signlab.presenters;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.interactors.LoginInteractorInt;
import com.sfr.practicas_signlab.views.LoginViewInt;
import com.sfr.practicas_signlab.MainViewInt;
import javax.inject.Inject;
public class LoginPresenter implements LoginPresenterInt, LoginInteractorInt.OnGetLoginCallBacks{
    @Nullable
    @Inject
    LoginViewInt loginview;

    @Nullable
    @Inject
    MainViewInt mainview;

    @Inject
    LoginInteractorInt interactor;

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    public LoginPresenter() {}

    @Override
    public void checkCredentials(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            interactor.checkCredentials(username, password, this);
        } else {
            mainview.onReedirigiraLoginActivity();
        }
    }

    public void guardarDatosSesion(String username, String password) {
        sharedPreferences.edit().putString("username", username).apply();
        sharedPreferences.edit().putString("password", password).apply();
    }

    public void obtenerCredenciales() {
        // Obtener el nombre de usuario y contraseña (con valores por defecto vacíos)
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        checkCredentials(username, password);
    }


    @Override
    public void checkCredentials(String username, String password, LoginInteractorInt.OnGetLoginCallBacks callBacks) {
        if (!username.isEmpty() && !password.isEmpty()) {
            interactor.checkCredentials(username, password, this);
        } else {
            mainview.onReedirigiraLoginActivity();
        }
    }

    @Override
    public void onSuccessCredentials(String username, String password) {
        guardarDatosSesion(username, password);
        if (loginview != null){
            loginview.onLoginCheck("Loggeado correctamente", true);
        } else {
            mainview.onReedirigiraHomeActivity();
        }
    }

    @Override
    public void onErrorCredentials() {
        if (loginview !=null) {
            loginview.onLoginCheck("Error al loggearse", false);
        }
    }
}