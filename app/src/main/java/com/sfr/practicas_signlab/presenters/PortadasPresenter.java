package com.sfr.practicas_signlab.presenters;

import android.util.Log;

import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.api.Models.User;
import com.sfr.practicas_signlab.interactors.PortadasInteractorInt;
import com.sfr.practicas_signlab.interactors.UsuariosInteractorInt;
import com.sfr.practicas_signlab.views.PortadasFragmentInt;
import com.sfr.practicas_signlab.views.UsuariosFragmentInt;

import java.util.ArrayList;

import javax.inject.Inject;

public class PortadasPresenter implements PortadasPresenterInt, PortadasInteractorInt.OnGetPhotosCallBacks, PortadasInteractorInt.OnErrorServer {

    PortadasFragmentInt portadasview;
    PortadasInteractorInt portadasinteractor;

    public PortadasPresenter(){}

    @Override
    public void onPhotosFetched() {
        portadasinteractor.getPhotosFromApi(this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Photo> photos) {
        Log.i("respuesta", String.valueOf(photos));
        portadasview.showPhotos(photos);

    }

    @Override
    public void onErrorCallBacks(int code) {
        Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
