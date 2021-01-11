package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.LoginPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.LoginPresenterViewContract.LoginViewInterface;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private LoginPresenter loginPresenter;

    @BindView(R.id.input_user_editText)
    public EditText inputUser;

    @BindView(R.id.input_password_editText)
    public EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.sign_in_button)
    void onClickSignIn(View view) {
//        if (!loginPresenter.verifyLogin(inputUser.getText().toString().trim(),
//                inputPassword.getText().toString().trim())) {
//            displayError(getString(R.string.login_fail_alert_message));
//        } else {
            startActivity(new Intent(this, MemberListActivity.class));
//        }
    }

    @Override
    public void displayError(String errorMessage) {
        new AlertDialog
                .Builder(new ContextThemeWrapper(LoginActivity.this, R.style.Theme_Wknd2_ass_GymMemberManager))
                .setTitle(R.string.login_fail_alert_title)
                .setMessage(errorMessage)
                .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}