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

    SearchView alumniSearch;
    ListView alumniList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alumniSearch = (SearchView)findViewById(R.id.search_view_alumni);
        alumniList = (ListView)findViewById(R.id.search_list_results);

        list.add("Bob");
        list.add("Bobby");
        list.add("Boblina");
        list.add("Bobby-joe");
        list.add("Bobsan");
        list.add("Bobbydo");
        list.add("Bobbydon't");
        list.add("Bobbie");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        alumniList.setAdapter(adapter);

        alumniSearch.setOnQueryTextListener(new SearchView.OnQueryTextListner() );
    }



    @Override
    public int getLayoutResource() {
        return R.layout.activity_find_alumni;
    }
}