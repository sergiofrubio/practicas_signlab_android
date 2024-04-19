package com.sfr.practicas_signlab.editarpost.interactor;

import com.sfr.practicas_signlab.api.wsApi.WsApi;
import com.sfr.practicas_signlab.editarpost.presenter.EditarPostPresenterImpl;

import javax.inject.Inject;

public class EditarPostInteractorImpl implements EditarPostInteractor{
    @Inject
    WsApi wsApi;

    @Inject
    public EditarPostInteractorImpl(){}

    @Override
    public void onSetDataToApi(String title, String body, OnErrorServer errorServer, EditarPostPresenterImpl presenter) {

    }
}
