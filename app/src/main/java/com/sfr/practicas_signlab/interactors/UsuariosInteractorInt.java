package com.sfr.practicas_signlab.interactors;

import com.sfr.practicas_signlab.api.Models.User;

import java.util.ArrayList;

public interface UsuariosInteractorInt {

    void getUsersFromApi(OnGetUsersCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetUsersCallBacks {
        void onSuccessCallBacks(ArrayList<User> users);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
