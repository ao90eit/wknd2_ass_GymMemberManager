package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.models.utils.SharedPreferencesCreator;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.LoginPresenterViewContract.*;

public class LoginPresenter implements LoginPresenterInterface {
    private LoginViewInterface loginView;
    private Context loginViewContext;

    private SharedPreferences preferences;
    private Resources resources;

    public LoginPresenter(LoginViewInterface loginView) {
        this.loginView = loginView;
        loginViewContext = loginView.getContext();

        resources = loginViewContext.getResources();

        preferences = new SharedPreferencesCreator()
                .createEncryptedPreferencesObject(loginViewContext);
    }

    @Override
    public boolean verifyLogin(String user, String password) {
        if (user.equals(preferences.getString(resources.getString(R.string.prefs_user_key), resources.getString(R.string.prefs_user_default))) &&
                password.equals(preferences.getString(resources.getString(R.string.prefs_password_key), resources.getString(R.string.prefs_password_default)))) {
            return true;
        }

        return false;
    }
}
