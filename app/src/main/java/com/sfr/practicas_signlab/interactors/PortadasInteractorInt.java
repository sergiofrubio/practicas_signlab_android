package com.sfr.practicas_signlab.interactors;

import com.sfr.practicas_signlab.api.Models.Photo;
import java.util.ArrayList;

public interface PortadasInteractorInt {

    void getPhotosFromApi(OnGetPhotosCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetPhotosCallBacks {
        void onSuccessCallBacks(ArrayList<Photo> photos);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
