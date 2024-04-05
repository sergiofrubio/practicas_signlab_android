package com.sfr.practicas_signlab.albunes.interactor;


import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.usuarios.interactor.UsuariosInteractor;

import java.util.ArrayList;

public interface AlbunesInteractor {

    void getAlbumsFromApi(OnGetAlbumsCallBacks callBacks, OnErrorServer errorServer);
    void getUsersFromApi(OnGetUsersCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetAlbumsCallBacks {
        void onAlbumSuccessCallBacks(ArrayList<Album> albums);
        void onAlbumErrorCallBacks(int code);
    }

    interface OnGetUsersCallBacks {
        void onSuccessCallBacks(ArrayList<User> users);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
