package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.AddMemberPresenterViewContract.AddMemberViewInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMemberActivity extends AppCompatActivity implements AddMemberViewInterface {
    private AddMemberPresenter addMemberPresenter;

    @BindView(R.id.add_given_name_editText)
    EditText givenNameEditText;

    @BindView(R.id.add_family_name_editText)
    EditText familyNameEditText;

    @BindView(R.id.add_phone_editText)
    EditText phoneEditText;

    @BindView(R.id.add_email_editText)
    EditText emailEditText;

    @BindView(R.id.add_member_level_spinner)
    Spinner memberLevelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.add_member_toolbar);
        toolbar.setTitle(R.string.add_member_toolbar_title);
        setSupportActionBar(toolbar);

        ArrayAdapter<CharSequence> enumAdapter = ArrayAdapter.createFromResource(this,
                R.array.member_level_array, android.R.layout.simple_spinner_item);
        enumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        memberLevelSpinner.setAdapter(enumAdapter);

        addMemberPresenter = new AddMemberPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.member_add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_member_menu_action_save:
                GymMember newMember = generateNewGymMember();
                if (newMember != null) {
                    addMemberPresenter.insertMember(newMember);
                    finish();
                }
                else
                    Toast.makeText(this, R.string.add_member_missing_values_toast, Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private GymMember generateNewGymMember() {
        String givenName = givenNameEditText.getText().toString().trim();
        String familyName = familyNameEditText.getText().toString().trim();
        String memberLevel = memberLevelSpinner.getSelectedItem().toString().trim().toUpperCase();
        String phone = phoneEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        if (givenName.equals("") || familyName.equals("") ||
                phone.equals("") || email.equals(""))
            return null;

        return new GymMember(givenName, familyName, GymMember.MemberLevel.valueOf(memberLevel), phone, email);
    }

    @Override
    public Context getContext() {
        return this;
    }
}