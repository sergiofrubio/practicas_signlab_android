package com.sfr.practicas_signlab.editarpost.view;

import com.sfr.practicas_signlab.api.Models.Post;

import retrofit2.Response;

public interface EditarPostView {
    void showAnswer(String s);

    void onShowSuccessData(Post response);
}
