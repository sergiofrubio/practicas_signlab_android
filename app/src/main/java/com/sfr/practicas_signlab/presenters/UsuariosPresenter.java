package com.sfr.practicas_signlab.presenters;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.views.UsuariosFragmentInt;
import com.sfr.practicas_signlab.interactors.UsuariosInteractorInt;

import java.util.ArrayList;

import javax.inject.Inject;

public class UsuariosPresenter implements UsuariosPresenterInt, UsuariosInteractorInt.OnGetUsersCallBacks, UsuariosInteractorInt.OnErrorServer {
    @Nullable
    @Inject
    UsuariosFragmentInt usuariosview;
    @Inject
    UsuariosInteractorInt usuariosinteractor;

    @Inject
    public UsuariosPresenter(){}

    @Override
    public void onUsersFetched() {
        usuariosinteractor.getUsersFromApi(this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<User> users) {
        Log.i("respuesta", String.valueOf(users));
        usuariosview.showUsers(users);
    }

    @Override
    public void onErrorCallBacks(int code) {
        Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
