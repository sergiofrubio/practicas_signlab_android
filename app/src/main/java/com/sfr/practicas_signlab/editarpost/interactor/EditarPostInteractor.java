package com.sfr.practicas_signlab.editarpost.interactor;

import com.sfr.practicas_signlab.api.Models.Post;

public interface EditarPostInteractor {
    void onSetDataToApi(int postId, int id, String title, String body, int userId, onSetDataToApiCallbacks callBacks, OnErrorServer errorServer);

    interface onSetDataToApiCallbacks {
        void onSetDataToApiSuccessCallbacks(Post response);
        void onErrorCallBacks(String s);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
