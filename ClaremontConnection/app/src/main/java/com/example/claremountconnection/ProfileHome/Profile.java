package com.example.claremountconnection.ProfileHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.ProfileEdit;
import com.example.claremountconnection.R;
import com.example.claremountconnection.Users;

import java.util.List;

public class Profile extends BaseActivityToolbar {

    private static final String TAG = "Profile";
    private Button button;

    private TextView textTitle;
    private TextView textFirstName;
    private TextView textMiddleName;
    private TextView textLastName;
    private TextView textEmail;
    private TextView textPhone;
    private TextView textJobTitle;
    private TextView textEmployer;
    private TextView textOrganizations;
    private TextView textState;
    private TextView textZip;
    private TextView textMajor;
    private TextView textMinor;
    private TextView textAreaOfStudy;
    private TextView textResearchInterests;
    private TextView textSkills;

    private List<Users> nameList;

    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        textTitle = findViewById(R.id.title);
        textFirstName = findViewById(R.id.first);
        textMiddleName = findViewById(R.id.middle);
        textLastName = findViewById(R.id.last);
        textEmail = findViewById(R.id.email);
        textPhone = findViewById(R.id.phone);
        textJobTitle = findViewById(R.id.job_title);
        textEmployer = findViewById(R.id.employer);
        textOrganizations = findViewById(R.id.organizations);
        textState = findViewById(R.id.state);
        textZip = findViewById(R.id.zip_code);
        textMajor = findViewById(R.id.major);
        textMinor = findViewById(R.id.minor);
        textAreaOfStudy = findViewById(R.id.area_of_study);
        textResearchInterests = findViewById(R.id.research_interests);
        textSkills = findViewById(R.id.skills);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        int id = dbHelper.getIDbyEmail(currentEmail) - 1;

        nameList = dbHelper.getAllUsers();
        user = nameList.get(id);
        textTitle.setText(user.getTitle());
        textFirstName.setText(user.getFirstName());
        textMiddleName.setText(user.getMiddleName());
        textLastName.setText(user.getLastName());
        textEmail.setText(user.getEmail());
        textPhone.setText(user.getPhone());
        textJobTitle.setText(user.getJobTitle());
        textEmployer.setText(user.getEmployer());
        textOrganizations.setText(user.getOrganization());
        textState.setText(user.getState());
        textZip.setText(user.getZip());
        textMajor.setText(user.getMajor());
        textMinor.setText(user.getMinor());
        textAreaOfStudy.setText(user.getAreaOfStudy());
        textResearchInterests.setText(user.getResearchInterests());
        textSkills.setText(user.getSkills());

        button = (Button) findViewById(R.id.button_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileEdit(user.getEmail());
            }
        });

    }
    public void openProfileEdit(String email) {
        Intent intent = new Intent(this, ProfileEdit.class);
        intent.putExtra("EMAIL_SESSION_ID", email);
        startActivity(intent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile;
    }
}