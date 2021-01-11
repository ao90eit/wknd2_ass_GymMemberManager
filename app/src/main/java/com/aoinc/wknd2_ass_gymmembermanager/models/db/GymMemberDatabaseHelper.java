package com.aoinc.wknd2_ass_gymmembermanager.models.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.aoinc.wknd2_ass_gymmembermanager.models.GymMember;

import java.util.ArrayList;
import java.util.List;

public class GymMemberDatabaseHelper extends SQLiteOpenHelper {

    private Resources resources;

    public static final String DATABASE_NAME = "gym_member_db";
    public static int DATABASE_VERSION = 1;

    public static final String GYM_MEMBER_TABLE_NAME = "gym_member_table";

    public static final String COLUMN_MEMBER_ID = "id";
    public static final String COLUMN_MEMBER_GIVEN_NAME = "given_name";
    public static final String COLUMN_MEMBER_FAMILY_NAME = "family_name";
    public static final String COLUMN_MEMBER_LEVEL = "member_level";
//    public static final String COLUMN_MEMBER_LEVEL_ID = "member_level_id";
    public static final String COLUMN_MEMBER_PHOTO_ID = "photo_id";
    public static final String COLUMN_MEMBER_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_MEMBER_EMAIL = "email";

    public GymMemberDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        resources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + GYM_MEMBER_TABLE_NAME + " ("
                + COLUMN_MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MEMBER_GIVEN_NAME + " TEXT, "
                + COLUMN_MEMBER_FAMILY_NAME + " TEXT, "
                + COLUMN_MEMBER_LEVEL + " TEXT, "
//                + COLUMN__MEMBER_LEVEL_ID + " INTEGER, "
                + COLUMN_MEMBER_PHOTO_ID + " INTEGER, "
                + COLUMN_MEMBER_PHONE_NUMBER + " INTEGER, "
                + COLUMN_MEMBER_EMAIL + " TEXT)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "DROP TABLE IF EXISTS " + DATABASE_NAME;
        db.execSQL(dropTable);
        DATABASE_VERSION = newVersion;
    }

    public List<GymMember> getFullMemberList() {
        List<GymMember> memberList = new ArrayList<>();

        Cursor cursor = getReadableDatabase()
                .rawQuery( "SELECT * FROM " + GYM_MEMBER_TABLE_NAME + " ORDER BY " + COLUMN_MEMBER_GIVEN_NAME + " ASC",
                null, null);
        cursor.move(-1);

        while (cursor.moveToNext()) {
            int memberID = cursor.getInt(cursor.getColumnIndex(COLUMN_MEMBER_ID));
            String givenName = cursor.getString(cursor.getColumnIndex(COLUMN_MEMBER_GIVEN_NAME));
            String familyName = cursor.getString(cursor.getColumnIndex(COLUMN_MEMBER_FAMILY_NAME));
            String memberLevel = cursor.getString(cursor.getColumnIndex(COLUMN_MEMBER_LEVEL));
            int photoResourceID = cursor.getInt(cursor.getColumnIndex(COLUMN_MEMBER_PHOTO_ID));
            int phoneNumber = cursor.getInt(cursor.getColumnIndex(COLUMN_MEMBER_PHONE_NUMBER));
            String email = cursor.getString(cursor.getColumnIndex(COLUMN_MEMBER_EMAIL));

            memberList.add(new GymMember(memberID, givenName, familyName,
                    GymMember.MemberLevel.valueOf(memberLevel), photoResourceID,
                    phoneNumber, email));
        }

        return memberList;
    }

    public void insertNewMemberIntoDatabase(GymMember gymMember) {
        ContentValues memberValues = new ContentValues();

        memberValues.put(COLUMN_MEMBER_GIVEN_NAME, gymMember.getGivenName());
        memberValues.put(COLUMN_MEMBER_FAMILY_NAME, gymMember.getFamilyName());
        memberValues.put(COLUMN_MEMBER_LEVEL, gymMember.getMemberLevel().toString());
        memberValues.put(COLUMN_MEMBER_PHOTO_ID, gymMember.getProfilePhotoResourceID());
        memberValues.put(COLUMN_MEMBER_PHONE_NUMBER, gymMember.getPhoneNumber());
        memberValues.put(COLUMN_MEMBER_EMAIL, gymMember.getEmail());

        getWritableDatabase().insert(GYM_MEMBER_TABLE_NAME, null, memberValues);
    }

    public void deleteMemberFromDatabase(int memberID) {
        String deleteSql = "DELETE FROM " + GYM_MEMBER_TABLE_NAME + " WHERE " + COLUMN_MEMBER_ID + " = " + memberID;
        getWritableDatabase().execSQL(deleteSql);
    }

    public void deleteAllMembersFromDatabase() {
        String deleteAllSql = "DELETE FROM " + GYM_MEMBER_TABLE_NAME;
        getWritableDatabase().execSQL(deleteAllSql);
    }
}
