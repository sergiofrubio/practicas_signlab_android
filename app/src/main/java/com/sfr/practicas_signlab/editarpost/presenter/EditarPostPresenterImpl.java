package com.sfr.practicas_signlab.editarpost.presenter;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.Post;
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
    public void onGuardar(int postId, int id, String title, String body, int userId)  {
        interactor.onSetDataToApi(postId, id, title, body, userId, this, this);
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
