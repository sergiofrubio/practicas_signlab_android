package com.sfr.practicas_signlab.crearpost.view;

import com.sfr.practicas_signlab.api.Models.Post;

public interface CrearPostView {
    void showAnswer(String s);

    void onShowSuccessData(Post response);
}
