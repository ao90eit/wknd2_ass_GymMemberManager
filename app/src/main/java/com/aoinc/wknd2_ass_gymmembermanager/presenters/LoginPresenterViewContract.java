package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;

public interface LoginPresenterViewContract {
    public interface LoginPresenterInterface {
        boolean verifyLogin(String user, String password);
    }

    public interface LoginViewInterface {
        void displayError(String errorMessage);
        Context getContext();
    }
}
