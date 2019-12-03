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

    // these arrays will store string ids
    ArrayList<String> profileIDarray = new ArrayList();
    ArrayList<String> opportunityIDarray = new ArrayList();
    int profileCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper dbHelper = new DatabaseHelper(this);



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

    private void setProfileCount(int count) {
        profileCount = count;
    }

    private int getProfileCount() {
        return profileCount;
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
        int count = 0;

        System.out.println(" id = " + id);

        if (id > 0) {
            // change these to get only recommended ones - same skills
            String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
            id = dbHelper.getIDbyEmail(currentEmail);

            String strID = Integer.toString(id);
            tempUser = dbHelper.getUsersByEmail(currentEmail);
            opportunityList = dbHelper.getOpportunitiesBySkill(tempUser.getSkills());
            usersList = dbHelper.getUsersBySkill(tempUser.getSkills());

            System.out.println("user list content: " + usersList.get(0).getID());

        }
        else {
            //change these to get only recommended ones - same skills
            opportunityList = dbHelper.getAllOpportunities();
            usersList = dbHelper.getAllUsers();
        }




        // db records start at 1 while arraylist start at 0
        int numRecords = dbHelper.getNumOfOpportunities();
        mExampleList = new ArrayList<>();

        // these are the tabs. get the info for opportunities here
        // opportunity name on line 1
        // contact on line 2
        // for loop to add new tabs equal to arraylist count
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_android, "Line 1", "Line 2"));
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_audio, "Line 3", "Line 4"));
        //mExampleList.add(new OpportunitiesGetText(R.drawable.ic_sun, "Line 5", "Line 6"));

        for (Users user : usersList) {
            int userID = dbHelper.getIDbyEmail(user.getEmail());
            mExampleList.add(new RecommenderGetText(R.drawable.ic_android, user.getFirstName() + " " + user.getLastName(), user.getEmail()));
            profileIDarray.add(String.valueOf(userID));
            System.out.println("get user id = " + userID);
            count += 1;
            setProfileCount(count);
            System.out.println("num of profiles displayed: " + profileCount);
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
                // position starts at 0 as an array would?
                if (position < getProfileCount()) {
                    openProfileDetail(profileIDarray.get(position).toString());
                    System.out.println("profile array size: " + profileIDarray.size());
                    System.out.println("position: " + position);
                    System.out.println("profiles displayed: " + getProfileCount());
                    System.out.println("profile ID " + profileIDarray.get(position).toString());
                    System.out.println("profile");
                }
                else {
                    openOpportunityDetail(opportunityIDarray.get(position - profileCount).toString());
                    System.out.println("position: " + position);
                    System.out.println("opportunity array size: " + opportunityIDarray.size());
                    System.out.println("profiles displayed: " + getProfileCount());
                    System.out.println("opportunity ID " + opportunityIDarray.get(position - profileCount).toString());
                    System.out.println("opportunity");
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
        ;
        profileId = String.valueOf(Integer.parseInt(profileId) - 1);
        intent.putExtra("PROFILE_SESSION_ID", profileId);
        startActivity(intent);
    }
}