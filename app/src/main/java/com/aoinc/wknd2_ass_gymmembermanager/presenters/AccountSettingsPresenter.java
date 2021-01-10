package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenterViewContract.*;

public class AccountSettingsPresenter implements AccountSettingsPresenterInterface {
    private AccountSettingsViewInterface accountSettingsView;

    public AccountSettingsPresenter(AccountSettingsViewInterface accountSettingsView) {
        this.accountSettingsView = accountSettingsView;
    }
}
