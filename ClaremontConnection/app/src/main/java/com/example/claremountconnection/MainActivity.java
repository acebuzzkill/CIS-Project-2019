package com.example.claremountconnection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView theTextView= (TextView) findViewById(R.id.textView2);
        theTextView.setText("We are pleased to welcome you to the CGU Connection app for alumni!");

        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        if (currentEmail == null) {
            // not logged in
        }
        else {
            // logged in

        }
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }
}


