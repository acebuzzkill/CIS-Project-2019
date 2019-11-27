package com.example.claremountconnection.Opportunities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

public class Opportunities extends BaseActivityToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] hardcodeList = {"Opportunity 1", "Opportunity 2", "Opportunity 3", "Opportunity 4"};

        ListAdapter oppAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hardcodeList);

        ListView resultList = (ListView) findViewById(R.id.search_list_results);

        resultList.setAdapter(oppAdapter);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_opportunities;
    }
}
