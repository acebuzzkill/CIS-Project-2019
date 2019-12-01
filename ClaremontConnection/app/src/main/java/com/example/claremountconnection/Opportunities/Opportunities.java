package com.example.claremountconnection.Opportunities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.Opportunities.OpportunitiesDetailsPage;
import com.example.claremountconnection.R;
import com.example.claremountconnection.Opportunity;

import java.util.ArrayList;
import java.util.List;

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

        if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
            // Hide Logout Button
            postButton.setEnabled(false);
        }
        else {
            // Show Logout Button
            final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        }
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_opportunities;
    }

    public void openOpportunitiesPost() {
        Intent intent = new Intent(this, OpportunitiesPost.class);
        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        intent.putExtra("EMAIL_SESSION_ID", currentEmail);
        startActivity(intent);
    }

    public void insertItem(int position, Opportunity opportunity) {
        // use this function below to add new tabs
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
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        List<Opportunity> opportunityList = dbHelper.getAllOpportunities();
     //   Opportunity opportunity = new Opportunity();



        // db records start at 1 while arraylist start at 0
        int numRecords = dbHelper.getNumOfOpportunities();
        System.out.println(numRecords);
        mExampleList = new ArrayList<>();

        // these are the tabs. get the info for opportunities here
        // opportunity name on line 1
        // contact on line 2
        // for loop to add new tabs equal to arraylist count
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_android, "Line 1", "Line 2"));
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_audio, "Line 3", "Line 4"));
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_sun, "Line 5", "Line 6"));

        for (Opportunity opportunity : opportunityList) {
            System.out.println(opportunity.getId());
            System.out.println(opportunity.getPost());
            System.out.println(opportunity.getSkill());
            System.out.println(opportunity.getContact());
            int id = opportunity.getId();
            String post = opportunity.getPost();
            String skill = opportunity.getSkill();
            String contact = opportunity.getContact();
            mExampleList.add(new OpportunitiesGetText(R.drawable.ic_android, opportunity.getPost(), opportunity.getSkill()));
           // insertItem(id, opportunity);
        }
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
            // Set a open details page here
            public void onItemClick(int position) {
                System.out.println(position + 1);
                openOpportunityDetail(position + 1);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void openOpportunityDetail (int opportunityId) {
        Intent intent = new Intent(this, OpportunitiesDetailsPage.class);
        // add the id needed to transfer to the detail page
        String idStr = String.valueOf(opportunityId);
        intent.putExtra("OPPORTUNITY_SESSION_ID", idStr);
        startActivity(intent);
    }
}