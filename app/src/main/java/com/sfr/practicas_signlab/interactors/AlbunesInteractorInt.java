package com.sfr.practicas_signlab.interactors;


import com.sfr.practicas_signlab.api.Models.Album;

import java.util.ArrayList;

public interface AlbunesInteractorInt {

    void getAlbumsFromApi(OnGetAlbumsCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetAlbumsCallBacks {
        void onSuccessCallBacks(ArrayList<Album> albums);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
