package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;
import com.aoinc.wknd2_ass_gymmembermanager.models.db.GymMemberDatabaseHelper;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract.*;

public class AddMemberPresenter implements AddMemberPresenterInterface {
    private AddMemberViewInterface addMemberView;
    private GymMemberDatabaseHelper gymMemberDatabaseHelper;

    public AddMemberPresenter(AddMemberViewInterface addMemberView) {
        this.addMemberView = addMemberView;
        gymMemberDatabaseHelper = new GymMemberDatabaseHelper(addMemberView.getContext());
    }

    @Override
    public void insertMember(GymMember insertMember) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                gymMemberDatabaseHelper.insertNewMemberIntoDatabase(insertMember);
            }
        }.start();
    }
}
