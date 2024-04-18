package com.sfr.practicas_signlab.detallepost.interactor;

import com.sfr.practicas_signlab.api.wsApi.WsApi;

import javax.inject.Inject;

public class DetallePostInteractorImpl implements DetallePostInteractor{
    @Inject
    WsApi wsApi;

    public DetallePostInteractorImpl(){}
    @Override
    public void getCommentsFromApi(int postId, onGetCommentsCallbacks callbacks) {

    }
}
