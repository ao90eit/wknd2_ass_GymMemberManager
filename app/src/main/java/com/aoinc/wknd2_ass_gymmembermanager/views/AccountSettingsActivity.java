package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenterViewContract.AccountSettingsViewInterface;

public class AccountSettingsActivity extends AppCompatActivity implements AccountSettingsViewInterface {
    private AccountSettingsPresenter accountSettingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        accountSettingsPresenter = new AccountSettingsPresenter(this);
    }
}