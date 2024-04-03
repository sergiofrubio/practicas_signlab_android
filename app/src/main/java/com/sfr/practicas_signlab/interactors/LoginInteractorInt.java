package com.sfr.practicas_signlab.interactors;

public interface LoginInteractorInt {
    void checkCredentials(String username, String password, LoginInteractorInt.OnGetLoginCallBacks callBacks);

    interface OnGetLoginCallBacks {
        void checkCredentials(String username, String password, OnGetLoginCallBacks callBacks);

        void onSuccessCredentials(String username, String password);
        void onErrorCredentials();
    }
}
