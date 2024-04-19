package com.sfr.practicas_signlab.detallepost.view;

import com.sfr.practicas_signlab.api.Models.Comment;

import java.util.ArrayList;

public interface DetallePostView {
    void ShowComments(ArrayList<Comment> comments);
}
