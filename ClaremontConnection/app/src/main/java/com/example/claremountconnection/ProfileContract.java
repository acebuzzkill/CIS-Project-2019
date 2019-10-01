package com.example.claremountconnection;

import android.provider.BaseColumns;

public final class ProfileContract {

    private ProfileContract() {}

    public static class UsersTable implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME = "name";
    }
}
