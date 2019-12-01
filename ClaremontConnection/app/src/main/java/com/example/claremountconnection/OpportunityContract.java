package com.example.claremountconnection;

import android.provider.BaseColumns;

public final class OpportunityContract {

    private OpportunityContract() {}

    public static class OpportunityTable implements BaseColumns {
        public static final String TABLE_NAME = "opportunity";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_POST = "post";
        public static final String COLUMN_SKILL = "skill";
        public static final String COLUMN_CONTACT = "contact";
    }
}