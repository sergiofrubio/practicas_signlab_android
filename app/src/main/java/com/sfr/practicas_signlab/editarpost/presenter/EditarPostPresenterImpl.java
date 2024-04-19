package com.sfr.practicas_signlab.editarpost.presenter;

import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.editarpost.interactor.EditarPostInteractor;
import com.sfr.practicas_signlab.editarpost.view.EditarPostView;
import javax.inject.Inject;

public class EditarPostPresenterImpl implements EditarPostPresenter, EditarPostInteractor.onSetDataToApiCallbacks, EditarPostInteractor.OnErrorServer{
    @Nullable
    @Inject
    EditarPostView view;
    @Inject
    EditarPostInteractor interactor;

    @Inject
    public EditarPostPresenterImpl(){}

    @Override
    public void onGuardar(String title, String body) {
        interactor.onSetDataToApi(title, body, this, this);
    }

    @Override
    public void onSetDataToApiSuccessCallbacks() {

    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
