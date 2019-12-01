package com.example.claremountconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.claremountconnection.ProfileContract.UsersTable;
import com.example.claremountconnection.OpportunityContract.OpportunityTable;

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
                UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
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

        final String SQL_CREATE_OPPORTUNITY_TABLE = "CREATE TABLE " +
                OpportunityTable.TABLE_NAME + " ( " +
                OpportunityTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OpportunityTable.COLUMN_POST + " TEXT, " +
                OpportunityTable.COLUMN_SKILL + " TEXT, " +
                OpportunityTable.COLUMN_CONTACT + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_USERS_TABLE);
        db.execSQL(SQL_CREATE_OPPORTUNITY_TABLE);
        fillUsersTable();
        fillOpportunityTable();
//        Intent intent = new Intent(DatabaseHelper.this, TestDisplayDBUser.class);
//        startActivity();

     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OpportunityTable.TABLE_NAME);
        onCreate(db);
        db.close();
    }


    private void fillUsersTable() {
        Users user1 = new Users ("Mr/Mrs", "firstName", "middleName", "lastName",
                "myEmail@email.com", "Pw1@", "myPhone", "myJob",
                "myEmployer", "myOrg", "myState", "myZip",
                "myMajor", "myMinor", "myStudies",
                "myResearchInterests", "mySkillset");
        addUser(user1);
    }

    private void fillOpportunityTable() {
        Opportunity opportunity1 = new Opportunity ("Software Engineer", "coding", "myEmail@email.com");
        Opportunity opportunity2 = new Opportunity ("Biology Research", "science", "myEmail@email.com");
        addOpportunity(opportunity1);
        addOpportunity(opportunity2);
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
        db.insert(UsersTable.TABLE_NAME, null, cv);
    }

    public void addOpportunity(Opportunity opportunity) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(OpportunityTable.COLUMN_POST, opportunity.getPost());
        cv.put(OpportunityTable.COLUMN_SKILL, opportunity.getSkill());
        cv.put(OpportunityTable.COLUMN_CONTACT, opportunity.getContact());
        db.insert(OpportunityTable.TABLE_NAME, null, cv);
    }

    public void updateUser(Users user) {
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_TITLE, user.getTitle());
        // test
        // cv.put(UsersTable.COLUMN_TITLE, "test");
        // test ^^
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
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(db.update(UsersTable.TABLE_NAME, cv, UsersTable.COLUMN_ID + "=" + id, null));
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

    public List<Opportunity> getAllOpportunities() {
        List<Opportunity> opportunitiesList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + OpportunityTable.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Opportunity opportunity = new Opportunity();
                // set values in here
                opportunity.setId(cursor.getInt(cursor.getColumnIndex(OpportunityTable.COLUMN_ID)));
                opportunity.setPost(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_POST)));
                opportunity.setSkill(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_SKILL)));
                opportunity.setContact(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_CONTACT)));
                opportunitiesList.add(opportunity);
            } while(cursor.moveToNext());
        }

        cursor.close();
        return opportunitiesList;
    }

    public Opportunity getOpportunity(String id) {
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + OpportunityTable.TABLE_NAME + " WHERE " + OpportunityTable.COLUMN_ID + " = ?", new String[]{id});
        if (cursor.moveToFirst()) {
            Opportunity opportunity = new Opportunity();
            opportunity.setId(cursor.getInt(cursor.getColumnIndex(OpportunityTable.COLUMN_ID)));
            opportunity.setPost(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_POST)));
            opportunity.setSkill(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_SKILL)));
            opportunity.setContact(cursor.getString(cursor.getColumnIndex(OpportunityTable.COLUMN_CONTACT)));
            cursor.close();
            return opportunity;
        }
        else {
            cursor.close();
            return null;
        }
    }

    public int getNumOfOpportunities() {
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + OpportunityTable.TABLE_NAME, null);
        if (cursor.moveToLast()) {
            int lastRecordId = cursor.getInt(cursor.getColumnIndex(OpportunityTable.COLUMN_ID));
            cursor.close();
            return lastRecordId;
        }
        else {
            cursor.close();
            return 0;
        }
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