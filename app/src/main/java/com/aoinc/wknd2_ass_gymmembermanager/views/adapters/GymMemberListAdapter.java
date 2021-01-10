package com.aoinc.wknd2_ass_gymmembermanager.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.wknd2_ass_gymmembermanager.R;
import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;

import java.util.List;

public class GymMemberListAdapter extends BaseAdapter {
    private GymMemberDelegate gymMemberDelegate;
    private List<GymMember> gymMemberList;

    public interface GymMemberDelegate {
        void SelectGymMember(GymMember selectedGymMember);
    }

    public GymMemberListAdapter(GymMemberDelegate gymMemberDelegate, List<GymMember> gymMemberList) {
        this.gymMemberDelegate = gymMemberDelegate;
        this.gymMemberList = gymMemberList;
    }

    @Override
    public int getCount() {
        return gymMemberList.size();
    }

    @Override
    public Object getItem(int position) {
        return gymMemberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GymMember curItem = gymMemberList.get(position);

        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_list_item_layout, parent, false);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gymMemberDelegate.SelectGymMember(curItem);
            }
        });

        ImageView profilePhoto = listItemView.findViewById(R.id.member_listView_photo_imageView);
        profilePhoto.setImageResource(curItem.getProfilePhotoResourceID());

        TextView fullName = listItemView.findViewById(R.id.member_listView_name_imageView);
        fullName.setText(new StringBuilder().append(curItem.getFirstName()).append(" ").append(curItem.getLastName()));

        ImageView memberLevelImage = listItemView.findViewById(R.id.member_listView_member_level_imageView);
        memberLevelImage.setImageResource(curItem.getMemberLevelImageResourceID());

        return listItemView;
    }
}
