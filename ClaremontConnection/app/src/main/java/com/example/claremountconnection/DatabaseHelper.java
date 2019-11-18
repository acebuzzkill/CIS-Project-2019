package com.example.claremountconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.claremountconnection.ProfileContract.UsersTable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ClaremontConnection.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " +
                UsersTable.TABLE_NAME + " ( " +
                UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                UsersTable.COLUMN_TITLE + " TEXT, " +
                UsersTable.COLUMN_FIRSTNAME + " TEXT, " +
                UsersTable.COLUMN_MIDDLENAME + " TEXT, " +
                UsersTable.COLUMN_LASTNAME + " TEXT, " +
                UsersTable.COLUMN_EMAIL + " TEXT, " +
                UsersTable.COLUMN_PASSWORD + " TEXT, " +
                UsersTable.COLUMN_PHONE + " TEXT, " +
                UsersTable.COLUMN_JOBTITLE + " TEXT, " +
                UsersTable.COLUMN_EMPLOYER + " TEXT, " +
                UsersTable.COLUMN_ORGANIZATIONS + " TEXT, " +
                UsersTable.COLUMN_STATE + " TEXT, " +
                UsersTable.COLUMN_ZIP + " TEXT, " +
                UsersTable.COLUMN_MAJOR + " TEXT, " +
                UsersTable.COLUMN_MINOR + " TEXT, " +
                UsersTable.COLUMN_AREAOFSTUDY + " TEXT, " +
                UsersTable.COLUMN_RESEARCHINTERESTS + " TEXT, " +
                UsersTable.COLUMN_SKILLS + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_USERS_TABLE);
        fillUsersTable();
//        Intent intent = new Intent(DatabaseHelper.this, TestDisplayDBUser.class);
//        startActivity();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME);
        onCreate(db);
        db.close();
    }


    private void fillUsersTable() {
        Users user1 = new Users ("Mr/Mrs", "firstName", "middleName", "lastName",
                "myEmail@email.com", "Pw1!", "myPhone", "myJob",
                "myEmployer", "myOrg", "myState", "myZip",
                "myMajor", "myMinor", "myStudies",
                "myResearchInterests", "mySkillset", 1);
        addUser(user1);
    }

    private void addUser(Users user) {
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_TITLE, user.getTitle());
        cv.put(UsersTable.COLUMN_FIRSTNAME, user.getFirstName());
        cv.put(UsersTable.COLUMN_LASTNAME, user.getLastName());
        cv.put(UsersTable.COLUMN_MIDDLENAME, user.getMiddleName());
        cv.put(UsersTable.COLUMN_EMAIL, user.getEmail());
        cv.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
        cv.put(UsersTable.COLUMN_PHONE, user.getPhone());
        cv.put(UsersTable.COLUMN_JOBTITLE, user.getJobTitle());
        cv.put(UsersTable.COLUMN_EMPLOYER, user.getEmployer());
        cv.put(UsersTable.COLUMN_ORGANIZATIONS, user.getOrganization());
        cv.put(UsersTable.COLUMN_STATE, user.getState());
        cv.put(UsersTable.COLUMN_ZIP, user.getZip());
        cv.put(UsersTable.COLUMN_MAJOR, user.getMajor());
        cv.put(UsersTable.COLUMN_MINOR, user.getMinor());
        cv.put(UsersTable.COLUMN_AREAOFSTUDY, user.getAreaOfStudy());
        cv.put(UsersTable.COLUMN_RESEARCHINTERESTS, user.getResearchInterests());
        cv.put(UsersTable.COLUMN_SKILLS, user.getSkills());
        // add id
        cv.put(UsersTable.COLUMN_ID, user.getID());
        db.insert(UsersTable.TABLE_NAME, null, cv);
    }

    public void updateUser(Users user) {
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_TITLE, user.getTitle());
        cv.put(UsersTable.COLUMN_FIRSTNAME, user.getFirstName());
        cv.put(UsersTable.COLUMN_LASTNAME, user.getLastName());
        cv.put(UsersTable.COLUMN_MIDDLENAME, user.getMiddleName());
        cv.put(UsersTable.COLUMN_EMAIL, user.getEmail());
        cv.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
        cv.put(UsersTable.COLUMN_PHONE, user.getPhone());
        cv.put(UsersTable.COLUMN_JOBTITLE, user.getJobTitle());
        cv.put(UsersTable.COLUMN_EMPLOYER, user.getEmployer());
        cv.put(UsersTable.COLUMN_ORGANIZATIONS, user.getOrganization());
        cv.put(UsersTable.COLUMN_STATE, user.getState());
        cv.put(UsersTable.COLUMN_ZIP, user.getZip());
        cv.put(UsersTable.COLUMN_MAJOR, user.getMajor());
        cv.put(UsersTable.COLUMN_MINOR, user.getMinor());
        cv.put(UsersTable.COLUMN_AREAOFSTUDY, user.getAreaOfStudy());
        cv.put(UsersTable.COLUMN_RESEARCHINTERESTS, user.getResearchInterests());
        cv.put(UsersTable.COLUMN_SKILLS, user.getSkills());
        String email = user.getEmail();
        int id = getIDbyEmail(email);
        //     String[] strArray = new String[] {email};
        //     strArray[0] = email;
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(db.update(UsersTable.TABLE_NAME, cv, UsersTable.COLUMN_ID + "=" + id, null));
        //    db.update(UsersTable.TABLE_NAME, cv, UsersTable.COLUMN_ID + "=" + id, null);
        db.close();
    }

    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Users user = new Users();
                user.setTitle(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_TITLE)));
                user.setFirstName(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_FIRSTNAME)));
                user.setLastName(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_LASTNAME)));
                user.setMiddleName(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_MIDDLENAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_PASSWORD)));
                user.setPhone(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_PHONE)));
                user.setJobTitle(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_JOBTITLE)));
                user.setEmployer(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_EMPLOYER)));
                user.setOrganization(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_ORGANIZATIONS)));
                user.setState(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_STATE)));
                user.setZip(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_ZIP)));
                user.setMajor(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_MAJOR)));
                user.setMinor(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_MINOR)));
                user.setAreaOfStudy(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_AREAOFSTUDY)));
                user.setResearchInterests(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_RESEARCHINTERESTS)));
                user.setSkills(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_SKILLS)));
                usersList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return usersList;
    }

    //check for email and password
    public Boolean emailPassword(String email, String password){
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UsersTable.TABLE_NAME + " where " + UsersTable.COLUMN_EMAIL + " = ? and " + UsersTable.COLUMN_PASSWORD + " = ?", new String[]{email,password});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    //insert new user email and password into database
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersTable.COLUMN_EMAIL,email);
        contentValues.put(UsersTable.COLUMN_PASSWORD,password);
        long ins = db.insert(UsersTable.TABLE_NAME,null,contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //check for email
    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + UsersTable.TABLE_NAME + " where " + UsersTable.COLUMN_EMAIL + " =?", new String[]{email});
        if(cursor.getCount()>0) { return false; }
        else {
            cursor.close();
            return true;
        }
    }

    // Get id of this email
    public int getIDbyEmail (String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME + " WHERE " + UsersTable.COLUMN_EMAIL + " =?", new String[]{email});
        if(cursor.moveToFirst()) {
            String id = cursor.getString(0);
            cursor.close();
            return Integer.parseInt(id);
        }
        else {
            return 0;
        }
    }

    public int getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int count = (int) DatabaseUtils.queryNumEntries(db, UsersTable.TABLE_NAME);
        db.close();
        return count;
    }
}