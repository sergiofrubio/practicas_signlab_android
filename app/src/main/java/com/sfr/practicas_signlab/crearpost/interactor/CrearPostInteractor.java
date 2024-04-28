package com.sfr.practicas_signlab.crearpost.interactor;

import com.sfr.practicas_signlab.api.Models.Post;

public interface CrearPostInteractor {
    void onAddDataToApi(int userId, String title, String body, CrearPostInteractor.onSetDataToApiCallbacks callBacks, CrearPostInteractor.OnErrorServer errorServer);
    void onEditDataToApi(int postId, int id, String title, String body, int userId, CrearPostInteractor.onSetDataToApiCallbacks callBacks, CrearPostInteractor.OnErrorServer errorServer);

    interface onSetDataToApiCallbacks {
        void onSetDataToApiSuccessCallbacks(Post response);
        void onErrorCallBacks(String s);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}

