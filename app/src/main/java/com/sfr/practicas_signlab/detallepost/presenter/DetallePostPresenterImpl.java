package com.sfr.practicas_signlab.detallepost.presenter;

import androidx.annotation.Nullable;

import com.sfr.practicas_signlab.api.Models.Comment;
import com.sfr.practicas_signlab.detallepost.interactor.DetallePostInteractor;
import com.sfr.practicas_signlab.detallepost.view.DetallePostView;

import java.util.ArrayList;

import javax.inject.Inject;

public class DetallePostPresenterImpl implements DetallePostPresenter, DetallePostInteractor.onGetCommentsCallbacks, DetallePostInteractor.OnErrorServer {
    @Nullable
    @Inject
    DetallePostView view;

    @Inject
    DetallePostInteractor interactor;

    @Inject
    public DetallePostPresenterImpl(){}

    @Override
    public void onCommentsSuccessCallBacks(ArrayList<Comment> comments) {

    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }

    @Override
    public void onCommentsFetched(int postId) {

    }
}
