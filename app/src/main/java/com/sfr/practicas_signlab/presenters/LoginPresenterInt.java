package com.sfr.practicas_signlab.presenters;

public interface LoginPresenterInt {
    void checkCredentials(String username, String password);
    void obtenerCredenciales();
}
