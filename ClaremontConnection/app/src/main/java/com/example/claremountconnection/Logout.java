package com.example.claremountconnection;

import android.content.Intent;
import android.os.Bundle;

import com.example.claremountconnection.MainActivity;

public class Logout extends BaseActivityToolbar {
    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentOpen = new Intent(this, MainActivity.class);
        startActivity(intentOpen);
    }

}
