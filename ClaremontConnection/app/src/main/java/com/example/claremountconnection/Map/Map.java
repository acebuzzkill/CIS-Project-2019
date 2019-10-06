package com.example.claremountconnection.Map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

public class Map extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_map;
    }
}