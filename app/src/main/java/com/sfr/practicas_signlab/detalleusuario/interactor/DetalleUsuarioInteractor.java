package com.sfr.practicas_signlab.detalleusuario.interactor;

import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import java.util.ArrayList;

public interface DetalleUsuarioInteractor {

    void getPostsFromApi(int userId, OnGetPostsCallBacks callBacks, OnErrorServer errorServer);
    void getTodosFromApi(int userId, OnGetTodosCallBacks callBacks, OnErrorServer errorServer);


    interface OnGetPostsCallBacks {
        void onPostsSuccessCallBacks(ArrayList<Post> posts);
        void onErrorCallBacks(int code);
    }

    interface OnGetTodosCallBacks {
        void onTodosSuccessCallBacks(ArrayList<Todo> todos);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }

}
