package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;
import com.aoinc.wknd2_ass_gymmembermanager.models.db.GymMemberDatabaseHelper;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenterViewContract.*;

public class MemberListPresenter implements MemberListPresenterInterface {
    private MemberListViewInterface memberListView;
    private GymMemberDatabaseHelper gymMemberDatabaseHelper;

    public MemberListPresenter(MemberListViewInterface memberListView) {
        this.memberListView = memberListView;
        gymMemberDatabaseHelper = new GymMemberDatabaseHelper(memberListView.getContext());
    }

    @Override
    public void getFullMemberList() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    memberListView.displayMemberList(gymMemberDatabaseHelper.getFullMemberList());
                } catch (Exception e) {
                    e.printStackTrace();
                    memberListView.displayError((e.getMessage()));
                }
            }
        }.start();
    }

    @Override
    public void insertMember(GymMember insertMember) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    gymMemberDatabaseHelper.insertNewMemberIntoDatabase(insertMember);
                } catch (Exception e) {
                    e.printStackTrace();
                    memberListView.displayError(e.getMessage());
                }
            }
        }.start();
    }

    @Override
    public void deleteMember(GymMember deleteMember) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    gymMemberDatabaseHelper.deleteMemberFromDatabase(deleteMember);
                } catch (Exception e) {
                    e.printStackTrace();
                    memberListView.displayError(e.getMessage());
                }
            }
        }.start();
    }

    @Override
    public void deleteAllMembers() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    gymMemberDatabaseHelper.deleteAllMembersFromDatabase();
                    memberListView.displayMemberList(gymMemberDatabaseHelper.getFullMemberList());
                } catch (Exception e) {
                    e.printStackTrace();
                    memberListView.displayError(e.getMessage());
                }
            }
        }.start();
    }
}
