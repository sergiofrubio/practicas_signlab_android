package com.sfr.practicas_signlab.editarpost.interactor;

import com.sfr.practicas_signlab.editarpost.presenter.EditarPostPresenterImpl;

public interface EditarPostInteractor {
    void onSetDataToApi(String title, String body, onSetDataToApiCallbacks callBacks, OnErrorServer errorServer);

    interface onSetDataToApiCallbacks {
        void onSetDataToApiSuccessCallbacks();
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
