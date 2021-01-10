package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenterViewContract.*;

public class MemberListPresenter implements MemberListPresenterInterface {
    MemberListViewInterface memberListView;

    public MemberListPresenter(MemberListViewInterface memberListView) {
        this.memberListView = memberListView;

    }
}
