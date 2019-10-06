package com.example.claremountconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
                UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UsersTable.COLUMN_NAME + " TEXT" +
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
    }


    private void fillUsersTable() {

        Users user1 = new Users ("Test Name");
        addUser(user1);
        Users user2 = new Users ("Name Two");
        addUser(user2);
    }

    private void addUser(Users user) {
        ContentValues cv = new ContentValues();
        cv.put(UsersTable.COLUMN_NAME, user.getName());
        db.insert(UsersTable.TABLE_NAME, null, cv);
    }

    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + UsersTable.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Users user = new Users();
                user.setName(cursor.getString(cursor.getColumnIndex(UsersTable.COLUMN_NAME)));
                usersList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return usersList;
    }
}