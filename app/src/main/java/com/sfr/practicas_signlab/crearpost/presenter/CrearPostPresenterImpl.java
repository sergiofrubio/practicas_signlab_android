package com.sfr.practicas_signlab.crearpost.presenter;

import androidx.annotation.Nullable;
import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.crearpost.interactor.CrearPostInteractor;
import com.sfr.practicas_signlab.crearpost.view.CrearPostView;

import javax.inject.Inject;

public class CrearPostPresenterImpl implements CrearPostPresenter, CrearPostInteractor.onSetDataToApiCallbacks, CrearPostInteractor.OnErrorServer {
    @Nullable
    @Inject
    CrearPostView view;
    @Inject
    CrearPostInteractor interactor;

    @Inject
    public CrearPostPresenterImpl(){}

    @Override
    public void onAddPost(int userId, String title, String body)  {
        interactor.onAddDataToApi(userId, title, body, this, this);
    }

    @Override
    public void onEditPost(int postId, int id, String title, String body, int userId)  {
        interactor.onEditDataToApi(postId, id, title, body, userId, this, this);
    }


    @Override
    public void onSetDataToApiSuccessCallbacks(Post response) {
        view.onShowSuccessData(response);

    }

    @Override
    public void onErrorCallBacks(String s) {
        view.showAnswer(s);

    }

    @Override
    public void errorServerMessage(String message) {
        view.showAnswer(message);

    }

}
