package com.aoinc.wknd2_ass_gymmembermanager.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.aoinc.wknd2_ass_gymmembermanager.R;

public class GymMember implements Parcelable {
    private int memberID;
    private String givenName;
    private String familyName;

    public enum MemberLevel { REGULAR, PLATINUM, GOLD };
    private MemberLevel memberLevel;
    private int memberLevelImageResourceID;

    private int profilePhotoResourceID;
    private int phoneNumber;
    private String email;

    public GymMember(String givenName, String familyName, MemberLevel memberLevel, int phoneNumber, String email) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.memberLevel = memberLevel;
        this.phoneNumber = phoneNumber;
        this.email = email;

        memberLevelImageResourceID = setMemberLevelResourceID(memberLevel);
        profilePhotoResourceID = setRandomProfilePhoto();
    }

    public GymMember(int memberID, String givenName, String familyName, MemberLevel memberLevel, int profilePhotoResourceID, int phoneNumber, String email) {
        this.memberID = memberID;
        this.givenName = givenName;
        this.familyName = familyName;
        this.memberLevel = memberLevel;
        this.profilePhotoResourceID = profilePhotoResourceID;
        this.phoneNumber = phoneNumber;
        this.email = email;

        memberLevelImageResourceID = setMemberLevelResourceID(memberLevel);
    }

    protected GymMember(Parcel in) {
        memberID = in.readInt();
        givenName = in.readString();
        familyName = in.readString();
        memberLevel = MemberLevel.valueOf(in.readString());
        memberLevelImageResourceID = in.readInt();
        profilePhotoResourceID = in.readInt();
        phoneNumber = in.readInt();
        email = in.readString();
    }

    public static final Creator<GymMember> CREATOR = new Creator<GymMember>() {
        @Override
        public GymMember createFromParcel(Parcel in) {
            return new GymMember(in);
        }

        @Override
        public GymMember[] newArray(int size) {
            return new GymMember[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(memberID);
        dest.writeString(givenName);
        dest.writeString(familyName);
        dest.writeString(memberLevel.toString());
        dest.writeInt(memberLevelImageResourceID);
        dest.writeInt(profilePhotoResourceID);
        dest.writeInt(phoneNumber);
        dest.writeString(email);
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
              return R.drawable.ic_laurel_platinum;
            case GOLD:
               return R.drawable.ic_laurel_gold;
            default:    // REGULAR
                return R.drawable.ic_laurel_bronze;
        }
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
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
