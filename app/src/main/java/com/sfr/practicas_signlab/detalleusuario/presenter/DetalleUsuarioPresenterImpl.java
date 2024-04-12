package com.sfr.practicas_signlab.detalleusuario.presenter;

import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import com.sfr.practicas_signlab.detalleusuario.interactor.DetalleUsuarioInteractor;
import com.sfr.practicas_signlab.detalleusuario.view.DetalleUsuarioView;
import java.util.ArrayList;
import javax.inject.Inject;

public class DetalleUsuarioPresenterImpl implements DetalleUsuarioPresenter, DetalleUsuarioInteractor.OnGetPostsCallBacks, DetalleUsuarioInteractor.OnGetTodosCallBacks, DetalleUsuarioInteractor.OnErrorServer{

    @Nullable
    @Inject
    DetalleUsuarioView view;

    @Inject
    DetalleUsuarioInteractor interactor;

    @Inject
    public DetalleUsuarioPresenterImpl(){}


    @Override
    public void onPostsFetched(int userId) {
        interactor.getPostsFromApi(userId, this, this);
    }

    @Override
    public void onTodosFetched(int userId) {
        interactor.getTodosFromApi(userId, this, this);

    }

    @Override
    public void onPostsSuccessCallBacks(ArrayList<Post> posts) { view.showPosts(posts); }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void onTodosSuccessCallBacks(ArrayList<Todo> todos) {
        view.showTodos(todos);
    }


    @Override
    public void errorServerMessage(String message) {

    }
}
