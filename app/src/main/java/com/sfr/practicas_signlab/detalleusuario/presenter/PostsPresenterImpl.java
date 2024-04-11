package com.sfr.practicas_signlab.detalleusuario.presenter;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.Photo;
import com.sfr.practicas_signlab.portadas.interactor.PortadasInteractor;
import com.sfr.practicas_signlab.portadas.view.PortadasFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class PostsPresenterImpl implements PostsPresenter, PortadasInteractor.OnGetPhotosCallBacks, PortadasInteractor.OnErrorServer {

    @Nullable
    @Inject
    PortadasFragment portadasview;

    @Inject
    PortadasInteractor portadasinteractor;

    @Inject
    public PostsPresenterImpl(){}

    @Override
    public void onPhotosFetched() {
        portadasinteractor.getPhotosFromApi(this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Photo> photos) {
        // Log.i("respuesta", String.valueOf(photos));
        portadasview.showPhotos(photos);

    }

    @Override
    public void onErrorCallBacks(int code) {
        //Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
