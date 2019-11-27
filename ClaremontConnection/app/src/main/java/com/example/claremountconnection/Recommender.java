package com.example.claremountconnection;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

import java.util.ArrayList;

public class Recommender extends BaseActivityToolbar {
    private ArrayList<RecommenderGetText> mExampleList;

    private RecyclerView mRecyclerView;
    private RecommenderAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createExampleList();
        buildRecyclerView();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_recommender;
    }

    public void insertItem(int position) {
        mExampleList.add(position, new RecommenderGetText(R.drawable.ic_android, "New Item At Position" + position, "This is Line 2"));
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

        mExampleList.add(new RecommenderGetText(R.drawable.ic_android, "Line 1", "Line 2"));
        mExampleList.add(new RecommenderGetText(R.drawable.ic_audio, "Line 3", "Line 4"));
        mExampleList.add(new RecommenderGetText(R.drawable.ic_sun, "Line 5", "Line 6"));

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recommenderView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecommenderAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecommenderAdapter.OnItemClickListener() {
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