package com.example.claremountconnection;

import android.provider.BaseColumns;

public final class ProfileContract {

    private ProfileContract() {}

    public static class UsersTable implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_FIRSTNAME = "firstName";
        public static final String COLUMN_MIDDLENAME = "middleName";
        public static final String COLUMN_LASTNAME = "lastName";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_JOBTITLE = "jobTitle";
        public static final String COLUMN_EMPLOYER = "employer";
        public static final String COLUMN_ORGANIZATIONS = "organizations";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_ZIP = "zip";
        public static final String COLUMN_MAJOR = "major";
        public static final String COLUMN_MINOR = "minor";
        public static final String COLUMN_AREAOFSTUDY = "areaOfStudy";
        public static final String COLUMN_RESEARCHINTERESTS = "researchInterests";
        public static final String COLUMN_SKILLS = "skills";
    }
}
