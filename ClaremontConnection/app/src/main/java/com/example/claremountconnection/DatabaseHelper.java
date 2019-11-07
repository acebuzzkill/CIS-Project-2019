package com.example.claremountconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ClaremontConnection.db";
    private static final int DATABASE_VERSION = 1;
    private static final String tableName = "users";
    private static final String ID = "ID";
    private static final String keyFirstName = "firstName";
    private static final String keyMiddleName = "middleName";
    private static final String keyLastName = "lastname";
    private static final String keytitle = "title";
    private static final String keyEmail = "email";
    private static final String keyPassword = "password";
    private static final String keyPhone = "phone";
    private static final String keyJobTite = "jobTitle";
    private static final String keyEmployer = "employer";
    private static final String keyOrganizations = "organizations";
    private static final String keyState= "state";
    private static final String keyZip= "zip";
    private static final String keyMajor = "major";
    private static final String keyMinor = "minor";
    private static final String keyAreaOfStudy = "areaOfStudy";
    private static final String keyResearchInterests = "researchInterests";
    private static final String keySkills = "skills";

    private SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " +
                tableName + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                keytitle + " TEXT, " +
                keyFirstName + " TEXT, " +
                keyMiddleName + " TEXT, " +
                keyLastName + " TEXT, " +
                keyEmail + " TEXT, " +
                keyPassword + " TEXT, " +
                keyPhone + " TEXT, " +
                keyJobTite + " TEXT, " +
                keyEmployer + " TEXT, " +
                keyOrganizations + " TEXT, " +
                keyState + " TEXT, " +
                keyZip + " TEXT, " +
                keyMajor + " TEXT, " +
                keyMinor + " TEXT, " +
                keyAreaOfStudy + " TEXT, " +
                keyResearchInterests + " TEXT, " +
                keySkills + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_USERS_TABLE);
//        Intent intent = new Intent(DatabaseHelper.this, TestDisplayDBUser.class);
//        startActivity();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }




    private void addUser(String title, String firstName, String lastName, String middleName
            , String email, String password, String phone, String jobTitle, String employer
            , String organization, String state, String zip, String major, String minor
            , String areaOfStudy, String researchInterests, String skills) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(keytitle, title);
        cv.put(keyFirstName, firstName);
        cv.put(keyLastName, lastName);
        cv.put(keyMiddleName, middleName);
        cv.put(keyEmail, email);
        cv.put(keyPassword, password);
        cv.put(keyPhone, phone);
        cv.put(keyJobTite, jobTitle);
        cv.put(keyEmployer, employer);
        cv.put(keyOrganizations, organization);
        cv.put(keyState, state);
        cv.put(keyZip,zip);
        cv.put(keyMajor, major);
        cv.put(keyMinor, minor);
        cv.put(keyAreaOfStudy, areaOfStudy);
        cv.put(keyResearchInterests, researchInterests);
        cv.put(keySkills, keySkills);
        cv.put(keySkills,skills);
        db.insert(tableName, null, cv);
        db.close();
    }

    private void fillUsersTable() {
        addUser("Mr/Mrs", "firstName", "lastName", "middleName",
                "myEmail@email.com", "Pw1!", "myPhone", "myJob",
                "myEmployer", "myOrg", "myState", "myZip",
                "myMajor", "myMinor", "myStudies",
                "myResearchInterests", "mySkills");
    }

  //  public List<Users> getAllUsers() {
 //       List<Users> usersList = new ArrayList<>();
 //       db = getReadableDatabase();
  //      Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);
//
  //      if (cursor.moveToFirst()) {
    //        do {
    //            Users user = new Users();
    //            user.setTitle(cursor.getString(cursor.getColumnIndex(keytitle)));
     //           user.setFirstName(cursor.getString(cursor.getColumnIndex(keyFirstName)));
     //           user.setLastName(cursor.getString(cursor.getColumnIndex(keyLastName)));
     //           user.setMiddleName(cursor.getString(cursor.getColumnIndex(keyMiddleName)));
     //           user.setEmail(cursor.getString(cursor.getColumnIndex(keyEmail)));
      //          user.setPassword(cursor.getString(cursor.getColumnIndex(keyPassword)));
      //          user.setPhone(cursor.getString(cursor.getColumnIndex(keyPhone)));
     //           user.setJobTitle(cursor.getString(cursor.getColumnIndex(keytitle)));
     //           user.setEmployer(cursor.getString(cursor.getColumnIndex(keyEmployer)));
     //           user.setOrganization(cursor.getString(cursor.getColumnIndex(keyOrganizations)));
     //           user.setState(cursor.getString(cursor.getColumnIndex(keyState)));
     //           user.setZip(cursor.getString(cursor.getColumnIndex(keyZip)));
     //           user.setMajor(cursor.getString(cursor.getColumnIndex(keyMajor)));
     //           user.setMinor(cursor.getString(cursor.getColumnIndex(keyMinor)));
     //           user.setAreaOfStudy(cursor.getString(cursor.getColumnIndex(keyAreaOfStudy)));
     //           user.setResearchInterests(cursor.getString(cursor.getColumnIndex(keyResearchInterests)));
     //           user.setSkills(cursor.getString(cursor.getColumnIndex(keySkills)));
     //       } while (cursor.moveToNext());
     //   }
//
  //      cursor.close();
  //      return usersList;
  //  }

    //Get user
    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db =this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT firstname, lastname FROM" + tableName;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("firstname", cursor.getString(cursor.getColumnIndex(keyFirstName)));
            user.put("lastname", cursor.getString(cursor.getColumnIndex(keyLastName)));
            userList.add(user);
        }
        return userList;
    }

    //check for email and password
    public Boolean emailPassword(String email, String password){
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + tableName + " where " + keyEmail + " = ? and " + keyPassword + " = ?", new String[]{email,password});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    //insert new user email and password into database
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //check for email
    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}