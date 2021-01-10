package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenterViewContract.MemberListViewInterface;

public class MemberListActivity extends AppCompatActivity implements MemberListViewInterface {
    private MemberListPresenter memberListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        memberListPresenter = new MemberListPresenter(this);
    }
}