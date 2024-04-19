package com.sfr.practicas_signlab.detallepost.interactor;

import com.sfr.practicas_signlab.api.Models.Comment;
import java.util.ArrayList;

public interface DetallePostInteractor {

    void getCommentsFromApi(int postId, onGetCommentsCallbacks callbacks, OnErrorServer errorServer);

    interface onGetCommentsCallbacks {
        void onCommentsSuccessCallBacks(ArrayList<Comment> comments);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
