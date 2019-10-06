package com.example.claremountconnection.Messages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

public class Messages extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_messages;
    }
}