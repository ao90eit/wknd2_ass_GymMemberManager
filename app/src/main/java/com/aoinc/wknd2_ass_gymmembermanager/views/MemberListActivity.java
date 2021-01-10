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
                // TODO: wait for Gym Member result, reload list view
                startActivity(new Intent(this, AddMemberActivity.class));
                break;
            case R.id.menu_action_delete_all_members:
                // TODO delete everything in the db, reload list view
                break;
            case R.id.menu_action_my_account:
                startActivity(new Intent(this, AccountSettingsActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        // TODO: determine if this is desired behavior...
        return super.onOptionsItemSelected(item);
    }
}