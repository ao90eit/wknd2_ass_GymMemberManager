package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.models.utils.SharedPreferencesCreator;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenterViewContract.*;

public class AccountSettingsPresenter implements AccountSettingsPresenterInterface {
    private AccountSettingsViewInterface accountSettingsView;
    private Context accountSettingsViewContext;

    private SharedPreferences preferences;
    private Resources resources;

    public AccountSettingsPresenter(AccountSettingsViewInterface accountSettingsView) {
        this.accountSettingsView = accountSettingsView;

        accountSettingsViewContext = accountSettingsView.getContext();
        resources = accountSettingsViewContext.getResources();

        preferences = new SharedPreferencesCreator()
                .createEncryptedPreferencesObject(accountSettingsView.getContext());
    }

    @Override
    public String getUserNameInput() {
        return preferences.getString(resources.getString(R.string.prefs_user_key),
                resources.getString(R.string.prefs_user_default));
    }

    @Override
    public String getPasswordInput() {
        return preferences.getString(resources.getString(R.string.prefs_password_key),
                resources.getString(R.string.prefs_password_default));
    }

    @Override
    public void UpdateAccountDetails(String newUserName, String newPassword) {
        preferences.edit().putString(resources.getString(R.string.prefs_user_key), newUserName).apply();
        preferences.edit().putString(resources.getString(R.string.prefs_password_key), newPassword).apply();
    }
}
