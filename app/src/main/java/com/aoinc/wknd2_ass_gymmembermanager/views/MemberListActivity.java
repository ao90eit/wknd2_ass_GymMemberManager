package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenterViewContract.MemberListViewInterface;

public class MemberListActivity extends AppCompatActivity implements MemberListViewInterface {
    private MemberListPresenter memberListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.member_list_toolbar);
        setSupportActionBar(toolbar);

        memberListPresenter = new MemberListPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.member_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_add_member:
                startActivity(new Intent(this, AddMemberActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}