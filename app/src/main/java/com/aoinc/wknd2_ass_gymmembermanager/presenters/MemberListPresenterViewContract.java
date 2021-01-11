package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;

import java.util.List;

public interface MemberListPresenterViewContract {
    public interface MemberListViewInterface {
        Context getContext();
        void displayMemberList(List<GymMember> gymMemberList);
        void displayError(String errorMessage);
    }

    public interface MemberListPresenterInterface {
        void getFullMemberList();
        void insertMember(GymMember insertMember);
        void deleteAllMembers();
    }
}
