package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenterViewContract.MemberDetailViewInterface;

public class MemberDetailActivity extends AppCompatActivity implements MemberDetailViewInterface {
    private MemberDetailPresenter memberDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        memberDetailPresenter = new MemberDetailPresenter(this);
    }
}