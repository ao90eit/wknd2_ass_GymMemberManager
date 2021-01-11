package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.models.db.GymMemberDatabaseHelper;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenterViewContract.*;

public class MemberDetailPresenter implements MemberDetailPresenterInterface {
    private MemberDetailViewInterface memberDetailView;
    GymMemberDatabaseHelper gymMemberDatabaseHelper;

    public MemberDetailPresenter(MemberDetailViewInterface memberDetailView) {
        this.memberDetailView = memberDetailView;
        gymMemberDatabaseHelper = new GymMemberDatabaseHelper(memberDetailView.getContext());
    }

    @Override
    public void deleteMember(int memberID) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                gymMemberDatabaseHelper.deleteMemberFromDatabase(memberID);
            }
        }.start();
    }
}
