package com.sfr.practicas_signlab.albunes.interactor;


import com.sfr.practicas_signlab.api.Models.Album;

import java.util.ArrayList;

public interface AlbunesInteractor {

    void getAlbumsFromApi(OnGetAlbumsCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetAlbumsCallBacks {
        void onSuccessCallBacks(ArrayList<Album> albums);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
