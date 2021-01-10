package com.aoinc.wknd2_ass_gymmembermanager.models;

import com.aoinc.wknd2_ass_gymmembermanager.R;

public class GymMember {
    private String firstName;
    private String lastName;
    private int memberID;

    private enum MemberLevel { REGULAR, PLATINUM, GOLD };
    private MemberLevel memberLevel;
    private int memberLevelImageResourceID;

    private int profilePhotoResourceID;
    private int phoneNumber;
    private String email;

    public GymMember(String firstName, String lastName, MemberLevel memberLevel, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberLevel = memberLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;

        memberLevelImageResourceID = setMemberLevelResourceID(memberLevel);
        profilePhotoResourceID = setRandomProfilePhoto();
    }

    private int setRandomProfilePhoto() {
        int[] photoResources = {
                R.drawable.profile_pic_1,
                R.drawable.profile_pic_2,
                R.drawable.profile_pic_3,
                R.drawable.profile_pic_4,
                R.drawable.profile_pic_5,
                R.drawable.profile_pic_6,
                R.drawable.profile_pic_7,
                R.drawable.profile_pic_8,
                R.drawable.profile_pic_9,
        };

        return photoResources[getRandomNumber(0, photoResources.length)];
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int setMemberLevelResourceID(MemberLevel memberLevel) {
        switch (memberLevel) {
            case PLATINUM:
              return R.drawable.ic_laurel_silver;
            case GOLD:
               return R.drawable.ic_laurel_gold;
            default:    // REGULAR
                return R.drawable.ic_laurel_bronze;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMemberID() {
        return memberID;
    }

    public MemberLevel getMemberLevel() {
        return memberLevel;
    }

    public int getMemberLevelImageResourceID() {
        return memberLevelImageResourceID;
    }

    public int getProfilePhotoResourceID() {
        return profilePhotoResourceID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
