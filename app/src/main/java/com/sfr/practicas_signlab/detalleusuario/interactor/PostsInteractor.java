package com.sfr.practicas_signlab.detalleusuario.interactor;

import com.sfr.practicas_signlab.api.Models.Photo;

import java.util.ArrayList;

public interface PostsInteractor {

    void getPhotosFromApi(OnGetPhotosCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetPhotosCallBacks {
        void onSuccessCallBacks(ArrayList<Photo> photos);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
