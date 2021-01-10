package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract.AddMemberViewInterface;

public class AddMemberActivity extends AppCompatActivity implements AddMemberViewInterface {
    private AddMemberPresenter addMemberPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        addMemberPresenter = new AddMemberPresenter(this);
    }
}