package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;

public interface AddMemberPresenterViewContract {
    public interface AddMemberPresenterInterface {
        void insertMember(GymMember insertMember);
    }

    public interface AddMemberViewInterface {
        Context getContext();
    }
}
