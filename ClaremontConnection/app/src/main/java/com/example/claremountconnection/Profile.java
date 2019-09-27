package com.example.claremountconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Profile extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile;
    }
}