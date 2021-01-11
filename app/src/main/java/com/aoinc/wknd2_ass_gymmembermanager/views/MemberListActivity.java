package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberListPresenterViewContract.MemberListViewInterface;
import com.aoinc.wknd2_ass_gymmembermanager.views.adapters.GymMemberListAdapter;
import com.aoinc.wknd2_ass_gymmembermanager.views.adapters.GymMemberListAdapter.GymMemberDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class MemberListActivity extends AppCompatActivity implements MemberListViewInterface, GymMemberDelegate {
    private MemberListPresenter memberListPresenter;

    @BindView(R.id.member_listView)
    public ListView gymMemberListView;
    private GymMemberListAdapter gymMemberListAdapter;

    public static final String TAG_PARCELED_MEMBER_OBJECT = "parceled_member_object";

    @BindView(R.id.empty_member_list_message_textView)
    public TextView emptyListTextView;

    @BindView(R.id.search_bar_editText)
    EditText searchBarEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.member_list_toolbar);
        setSupportActionBar(toolbar);

        memberListPresenter = new MemberListPresenter(this);

        // DEBUG ONLY
        GenerateTestMembers();

        gymMemberListView.setEmptyView(emptyListTextView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        memberListPresenter.getFullMemberList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        searchBarEditText.setText("");
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
                break;
            case R.id.menu_action_delete_all_members:
                memberListPresenter.deleteAllMembers();
                break;
            case R.id.menu_action_my_account:
                startActivity(new Intent(this, AccountSettingsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void displayMemberList(List<GymMember> gymMemberList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gymMemberListAdapter = new GymMemberListAdapter(MemberListActivity.this, gymMemberList);
                gymMemberListView.setAdapter(gymMemberListAdapter);
            }
        });
    }

    @Override
    public void displayError(String errorMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog
                        .Builder(MemberListActivity.this, R.style.Theme_Wknd2_ass_GymMemberManager)
                        .setTitle(R.string.query_fail_alert_title)
                        .setMessage(R.string.query_fail_alert_message)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        });
    }

    @Override
    public void SelectGymMember(GymMember selectedGymMember) {
        Intent intent = new Intent(this, MemberDetailActivity.class);
        intent.putExtra(TAG_PARCELED_MEMBER_OBJECT, selectedGymMember);

        startActivity(intent);
    }

    @OnTextChanged(value = R.id.search_bar_editText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onSearchTextChanged(Editable editable) {
        memberListPresenter.getFilteredMemberList(editable.toString().trim());
    }

    // DEBUG ONLY
    private void GenerateTestMembers() {
        for (int i = 0; i < 3; i++) {
            memberListPresenter.insertMember(new GymMember("Burt", "Reynolds",
                    GymMember.MemberLevel.GOLD, "1234567890", "burt.reynolds@gmail.com"));

            memberListPresenter.insertMember(new GymMember("Jane", "Addams",
                    GymMember.MemberLevel.GOLD, "1122334455", "jane.addams@gmail.com"));

            memberListPresenter.insertMember(new GymMember("Butch", "Cassidy",
                    GymMember.MemberLevel.GOLD, "1102030405", "butch.cassidy@gmail.com"));

            memberListPresenter.insertMember(new GymMember("Ernest", "Hemingway",
                    GymMember.MemberLevel.GOLD, "1102030405", "ernest.hemingway@gmail.com"));

            memberListPresenter.insertMember(new GymMember("Cleo", "Patra",
                    GymMember.MemberLevel.GOLD, "1102030405", "Funky.CatLady@gmail.com"));
        }
    }
}