package com.example.claremountconnection.Opportunities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.ProfileEdit;
import com.example.claremountconnection.R;

import java.util.ArrayList;

public class Opportunities extends BaseActivityToolbar {
    private ArrayList<OpportunitiesGetText> mExampleList;

    private RecyclerView mRecyclerView;
    private OpportunitiesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button postButton;
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createExampleList();
        buildRecyclerView();

        postButton = (Button) findViewById(R.id.post_button);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpportunitiesPost();
            }
        });
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_opportunities;
    }

    public void openOpportunitiesPost() {
        Intent intent = new Intent(this, OpportunitiesPost.class);
        startActivity(intent);
    }

    public void insertItem(int position) {
        mExampleList.add(position, new OpportunitiesGetText(R.drawable.ic_android, "New Item At Position" + position, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();

        mExampleList.add(new OpportunitiesGetText(R.drawable.ic_android, "Line 1", "Line 2"));
        mExampleList.add(new OpportunitiesGetText(R.drawable.ic_audio, "Line 3", "Line 4"));
        mExampleList.add(new OpportunitiesGetText(R.drawable.ic_sun, "Line 5", "Line 6"));

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.opportunitiesView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new OpportunitiesAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OpportunitiesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

}