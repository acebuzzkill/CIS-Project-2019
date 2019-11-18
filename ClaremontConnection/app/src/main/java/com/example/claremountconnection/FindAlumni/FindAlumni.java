package com.example.claremountconnection.FindAlumni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

import java.util.ArrayList;

public class FindAlumni extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_find_alumni;
    }
}