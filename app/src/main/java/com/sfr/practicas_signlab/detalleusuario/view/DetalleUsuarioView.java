package com.sfr.practicas_signlab.detalleusuario.view;

import com.sfr.practicas_signlab.api.Models.Post;
import com.sfr.practicas_signlab.api.Models.Todo;
import java.util.ArrayList;

public interface DetalleUsuarioView {
    void showTodos(ArrayList<Todo> todos);
    void showPosts(ArrayList<Post> posts);
}
