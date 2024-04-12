package com.sfr.practicas_signlab.login.interactor;

public interface LoginInteractor {
    void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks);

    interface OnGetLoginCallBacks {
        void onSuccessCredentials(String username, String password);
        void onErrorCredentials();
    }
}
