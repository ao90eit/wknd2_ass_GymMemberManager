package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;

public interface AccountSettingsPresenterViewContract {
    public interface AccountSettingsPresenterInterface {
        String getUserNameInput();
        String getPasswordInput();
        void UpdateAccountDetails(String newUserName, String newPassword);
    }

    public interface AccountSettingsViewInterface {
        void populateAccountInformation();
        Context getContext();
    }
}
