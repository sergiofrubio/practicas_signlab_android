package com.sfr.practicas_signlab.interactors;

import javax.inject.Inject;

public class LoginInteractor implements LoginInteractorInt {
    private static final String CORRECT_USERNAME = "sergiofrubio@gmail.com";
    private static final String CORRECT_PASSWORD = "6649";
    @Inject
    public LoginInteractor() {}

    @Override
    public void checkCredentials(String username, String password, LoginInteractorInt.OnGetLoginCallBacks callBacks) {
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)){
            callBacks.onSuccessCredentials(CORRECT_USERNAME, CORRECT_PASSWORD);
        } else {
            callBacks.onErrorCredentials();
        }
    }
}
