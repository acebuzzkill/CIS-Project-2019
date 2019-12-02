package com.example.claremountconnection;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.Opportunities.OpportunitiesDetailsPage;
import com.example.claremountconnection.Opportunities.OpportunitiesGetText;
import com.example.claremountconnection.ProfileHome.Profile;
import com.example.claremountconnection.R;

import java.util.ArrayList;
import java.util.List;

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
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        ArrayList<String> profileIDarray = new ArrayList();
        ArrayList<String> opportunityIDarray = new ArrayList();
        int profileCount = 0;
        int opportunityCount = 0;
        int id = 0;

        if (getIntent().getStringExtra(("EMAIL_SESSION_ID")) == null) {

        }
        else {
            String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
            id = dbHelper.getIDbyEmail(currentEmail);
            System.out.println("id cookie accepted " + id);
        }

        createExampleList(profileCount, opportunityCount, profileIDarray, opportunityIDarray, id);
        buildRecyclerView(profileCount, opportunityCount, profileIDarray, opportunityIDarray, id);
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

    public void createExampleList(int profileCount, int opportunityCount, ArrayList profileIDarray, ArrayList opportunityIDarray, int id) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Users tempUser;
        List<Opportunity> opportunityList;
        List<Users> usersList;

        System.out.println(" id = " + id);

        if (id > 0) {
            // change these to get only recommended ones - same skills
            String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
            id = dbHelper.getIDbyEmail(currentEmail);

            String strID = Integer.toString(id);
            tempUser = dbHelper.getUsersByEmail(currentEmail);
            opportunityList = dbHelper.getOpportunitiesBySkill(tempUser.getSkills());
            usersList = dbHelper.getUsersBySkill(tempUser.getSkills());

            System.out.println("user list content" + usersList.get(0));
            System.out.println(id);
        }
        else {
            //change these to get only recommended ones - same skills
            opportunityList = dbHelper.getAllOpportunities();
            usersList = dbHelper.getAllUsers();
        }




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

        for (Users user : usersList) {
            mExampleList.add(new RecommenderGetText(R.drawable.ic_android, user.getFirstName() + " " + user.getLastName(), user.getEmail()));
            profileCount =+ 1;
            profileIDarray.add(user.getID());
        }

        for (Opportunity opportunity : opportunityList) {
            String post = opportunity.getPost();
            String skill = opportunity.getSkill();
            String contact = opportunity.getContact();
            mExampleList.add(new RecommenderGetText(R.drawable.ic_android, opportunity.getPost(), opportunity.getSkill()));
            opportunityIDarray.add(opportunity.getId());
        }
    }

    public void buildRecyclerView(final int profileCount, final int opportunityCount, final ArrayList profileIDarray, final ArrayList opportunityIDarray, int id) {
        mRecyclerView = findViewById(R.id.recommenderView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecommenderAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecommenderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println(position + 1);

                if (position <= profileCount) {
                    openProfileDetail(String.valueOf(profileIDarray.get(profileIDarray.indexOf(position))) + 1);

                }
                else {
                    openOpportunityDetail(String.valueOf(opportunityIDarray.get(opportunityIDarray.indexOf(position))));

                }
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void openOpportunityDetail (String opportunityId) {
        Intent intent = new Intent(this, OpportunitiesDetailsPage.class);
        // add the id needed to transfer to the detail page
        String idStr = String.valueOf(opportunityId);
        intent.putExtra("OPPORTUNITY_SESSION_ID", opportunityId);
        startActivity(intent);
    }

    public void openProfileDetail (String profileId) {
        Intent intent = new Intent(this, Profile.class);
        // add the id needed to transfer to the detail page
        String idStr = String.valueOf(profileId);
        intent.putExtra("PROFILE_SESSION_ID", profileId);
        startActivity(intent);
    }
}