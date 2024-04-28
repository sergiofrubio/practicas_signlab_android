package com.sfr.practicas_signlab.crearpost.presenter;

public interface CrearPostPresenter {
    void onAddPost(int userId, String title, String body);
    void onEditPost(int postId, int id, String title, String body, int userId);}
