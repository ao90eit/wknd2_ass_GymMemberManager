package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import android.content.Context;
import android.content.Intent;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;

public interface MemberDetailPresenterViewContract {
    public interface MemberDetailPresenterInterface {
        void deleteMember(int memberID);
    }

    public interface MemberDetailViewInterface {
        void populateDetailDisplay(GymMember gymMember);
        Context getContext();
    }
}
