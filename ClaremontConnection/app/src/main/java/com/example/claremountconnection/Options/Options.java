package com.example.claremountconnection.Options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

public class Options extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_options;
    }
}