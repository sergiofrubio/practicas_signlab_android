package com.sfr.practicas_signlab.presenters;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.interactors.AlbunesInteractorInt;
import com.sfr.practicas_signlab.views.AlbunesFragmentInt;

import java.util.ArrayList;

import javax.inject.Inject;

public class AlbunesPresenter implements AlbunesPresenterInt, AlbunesInteractorInt.OnGetAlbumsCallBacks, AlbunesInteractorInt.OnErrorServer {
    @Nullable
    @Inject
    AlbunesFragmentInt view;

    @Inject
    AlbunesInteractorInt albunesinteractor;

    @Inject
    public AlbunesPresenter(){}

    @Override
    public void onAlbumsFetched() {
        albunesinteractor.getAlbumsFromApi(this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Album> albums) {
        Log.i("respuesta", String.valueOf(albums));
        view.showAlbums(albums);
    }

    @Override
    public void onErrorCallBacks(int code) {
        Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
