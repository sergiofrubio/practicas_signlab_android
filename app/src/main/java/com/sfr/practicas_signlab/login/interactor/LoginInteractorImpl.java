package com.sfr.practicas_signlab.login.interactor;

import javax.inject.Inject;

public class LoginInteractorImpl implements LoginInteractor {
    private static final String CORRECT_USERNAME = "user";
    private static final String CORRECT_PASSWORD = "user";
    @Inject
    public LoginInteractorImpl() {}

    @Override
    public void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks) {
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)){
            callBacks.onSuccessCredentials(CORRECT_USERNAME, CORRECT_PASSWORD);
        } else {
            callBacks.onErrorCredentials();
        }
    }
}
