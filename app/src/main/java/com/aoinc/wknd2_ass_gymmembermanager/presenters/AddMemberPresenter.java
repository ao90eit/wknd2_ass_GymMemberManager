package com.aoinc.wknd2_ass_gymmembermanager.presenters;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract.*;

public class AddMemberPresenter implements AddMemberPresenterInterface {
    private AddMemberViewInterface addMemberView;

    public AddMemberPresenter(AddMemberViewInterface addMemberView) {
        this.addMemberView = addMemberView;
    }
}
