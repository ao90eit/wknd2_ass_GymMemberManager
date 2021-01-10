package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.LoginPresenterViewContract.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class LoginPresenter implements LoginPresenterInterface {
    private LoginViewInterface loginView;
    private Context loginViewContext;
    private SharedPreferences preferences;

    private static final String prefsUserKey = "user";
    private static final String prefsPasswordKey = "password";

    public LoginPresenter(LoginViewInterface loginView) {
        this.loginView = loginView;
        loginViewContext = loginView.getContext();
        preferences = setupEncryptedPreferences(loginViewContext);
    }

    private SharedPreferences setupEncryptedPreferences(Context loginViewContext) {
        MasterKey masterKey;
        try {
            masterKey = new MasterKey.Builder(loginViewContext)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            return EncryptedSharedPreferences.create(
                    loginViewContext,
                    loginViewContext.getPackageName(),
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean verifyLogin(String user, String password) {
        Resources resources = loginViewContext.getResources();

        if (user.equals(preferences.getString(prefsUserKey, resources.getString(R.string.prefs_user_default))) &&
                password.equals(preferences.getString(prefsPasswordKey, resources.getString(R.string.prefs_password_default)))) {
            return true;
        }

        return false;
    }
}
