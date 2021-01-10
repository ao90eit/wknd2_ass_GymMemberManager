package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenterViewContract.*;

public class MemberDetailPresenter implements MemberDetailPresenterInterface {
    private MemberDetailViewInterface memberDetailView;

    public MemberDetailPresenter(MemberDetailViewInterface memberDetailView) {
        this.memberDetailView = memberDetailView;
    }
}
