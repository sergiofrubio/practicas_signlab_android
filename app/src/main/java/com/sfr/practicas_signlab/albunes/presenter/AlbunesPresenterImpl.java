package com.sfr.practicas_signlab.albunes.presenter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.Album;
import com.sfr.practicas_signlab.albunes.interactor.AlbunesInteractor;
import com.sfr.practicas_signlab.albunes.view.AlbunesFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class AlbunesPresenterImpl implements AlbunesPresenter, AlbunesInteractor.OnGetAlbumsCallBacks, AlbunesInteractor.OnErrorServer {
    @Nullable
    @Inject
    AlbunesFragment view;

    @Inject
    AlbunesInteractor albunesinteractor;

    @Inject
    public AlbunesPresenterImpl(){}

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
