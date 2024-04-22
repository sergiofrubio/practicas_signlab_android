package com.sfr.practicas_signlab.editarpost.presenter;

public interface EditarPostPresenter{
    void onGuardar(int postId, int id, String title, String body, int userId);
}
