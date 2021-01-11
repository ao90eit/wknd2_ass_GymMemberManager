package com.aoinc.wknd2_ass_gymmembermanager.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aoinc.wknd2_ass_gymmembermanager.R;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenter;
import com.aoinc.wknd2_ass_gymmembermanager.presenters.MemberDetailPresenterViewContract.MemberDetailViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemberDetailActivity extends AppCompatActivity implements MemberDetailViewInterface {
    private MemberDetailPresenter memberDetailPresenter;

    @BindView(R.id.member_detail_photo_image_view)
    ImageView profilePhotoImageView;

    @BindView(R.id.member_detail_full_name_textView)
    TextView fullNameTextView;

    @BindView(R.id.member_detail_level_icon_imageView)
    ImageView memberLevelIconImageView;

    @BindView(R.id.member_detail_id_number_textView)
    TextView memberIDTextView;

    @BindView(R.id.member_detail_level_type_textView)
    TextView memberLevelTextView;

    @BindView(R.id.member_detail_phone_number_textView)
    TextView phoneTextView;

    @BindView(R.id.member_detail_email_address_textView)
    TextView emailTextView;

    GymMember currentGymMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.member_detail_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        memberDetailPresenter = new MemberDetailPresenter(this);

        currentGymMember = getIntent().getParcelableExtra(MemberListActivity.TAG_PARCELED_MEMBER_OBJECT);
        populateDetailDisplay(currentGymMember);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.member_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_delete_member:
                memberDetailPresenter.deleteMember(currentGymMember.getMemberID());
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.member_detail_call_imageButton)
    void onClickCallButton (View view) {
        Toast.makeText(this,
                getResources().getString( R.string.member_detail_call_toast,
                        phoneTextView.getText().toString().trim()),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void populateDetailDisplay(GymMember member) {
        profilePhotoImageView.setImageResource(member.getProfilePhotoResourceID());

        String fullName = new StringBuilder().append(member.getGivenName())
                .append(" ")
                .append(member.getFamilyName())
                .toString();
        fullNameTextView.setText(fullName);

        memberLevelIconImageView.setImageResource(member.getMemberLevelImageResourceID());
        String idNumber = new StringBuilder().append("#").append(String.valueOf(member.getMemberID())).toString();
        memberIDTextView.setText(idNumber);
        memberLevelTextView.setText(member.getMemberLevel().toString());

        String phoneNumber = member.getPhoneNumber();
        String formattedPhoneNum = String.format("%S-%s-%s",
                phoneNumber.substring(0,3), phoneNumber.substring(3,6), phoneNumber.substring(6));
        phoneTextView.setText(formattedPhoneNum);

        emailTextView.setText(member.getEmail());
    }

    @Override
    public Context getContext() {
        return this;
    }
}