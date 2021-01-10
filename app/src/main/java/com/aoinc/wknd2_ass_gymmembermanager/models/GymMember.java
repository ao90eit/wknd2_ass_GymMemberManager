package com.aoinc.wknd2_ass_gymmembermanager.models;

public class GymMember {
    private String firstName;
    private String lastName;
    private int memberID;

    enum MemberLevel { REGULAR, PLATINUM, GOLD };
    private MemberLevel memberLevel;

    private int profilePhotoResourceID;
    private int phoneNumber;
    private String email;

    public GymMember(String firstName, String lastName, int memberID, MemberLevel memberLevel, int profilePhotoResourceID, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberID = memberID;
        this.memberLevel = memberLevel;
        this.profilePhotoResourceID = profilePhotoResourceID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public MemberLevel getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(MemberLevel memberLevel) {
        this.memberLevel = memberLevel;
    }

    public int getProfilePhotoResourceID() {
        return profilePhotoResourceID;
    }

    public void setProfilePhotoResourceID(int profilePhotoResourceID) {
        this.profilePhotoResourceID = profilePhotoResourceID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
