package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AccountSettingsPresenterViewContract.AccountSettingsViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountSettingsActivity extends AppCompatActivity implements AccountSettingsViewInterface {
    private AccountSettingsPresenter accountSettingsPresenter;

    @BindView(R.id.account_user_name_editText)
    public TextView usernameEditText;

    @BindView(R.id.account_password_editText)
    public TextView passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        ButterKnife.bind(this);

        accountSettingsPresenter = new AccountSettingsPresenter(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.account_settings_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        populateAccountInformation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.account_settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account_menu_action_save:
                tryUpdateAccountDetails();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void populateAccountInformation() {
        usernameEditText.setText(accountSettingsPresenter.getUserNameInput());
        passwordEditText.setText(accountSettingsPresenter.getPasswordInput());
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void tryUpdateAccountDetails () {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!username.equals(accountSettingsPresenter.getUserNameInput()) ||
                !password.equals(accountSettingsPresenter.getPasswordInput())) {
            accountSettingsPresenter.UpdateAccountDetails(username, password);
        }
    }
}