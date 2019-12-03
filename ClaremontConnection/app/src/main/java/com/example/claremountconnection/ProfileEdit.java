package com.example.claremountconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.ProfileHome.Profile;
import com.example.claremountconnection.Users;
import com.google.android.material.textfield.TextInputLayout;
import android.content.Intent;

import java.util.List;

public class ProfileEdit extends AppCompatActivity {

    private Button button;

    private EditText textTitle;
    private EditText textFirstName;
    private EditText textMiddleName;
    private EditText textLastName;
    private EditText textEmail;
    private EditText textPhone;
    private EditText textJobTitle;
    private EditText textEmployer;
    private EditText textOrganizations;
    private EditText textState;
    private EditText textZip;
    private EditText textMajor;
    private EditText textMinor;
    private EditText textAreaOfStudy;
    private EditText textResearchInterests;
    private EditText textSkills;

    private List<Users> nameList;
    private Users user;
    private Users account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        // variable values from the textbox
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

        final DatabaseHelper dbHelper = new DatabaseHelper(this);

        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        final int id = dbHelper.getIDbyEmail(currentEmail);
        int arrayID = id - 1;
    //  Set each editbox value to values from the database
        nameList = dbHelper.getAllUsers();
        user = nameList.get(arrayID);
        if(user.getTitle() != null){
            textTitle.setText(user.getTitle());
    //        user.setTitle(textTitle.getText().toString().trim());
        }
        if(user.getFirstName() != null){
            textFirstName.setText(user.getFirstName());
        }
        if(user.getMiddleName() != null){
            textMiddleName.setText(user.getMiddleName());
        }
        if(user.getLastName() != null){
            textLastName.setText(user.getLastName());
        }
        if(user.getEmail() != null){
            textEmail.setText(user.getEmail());
        }
        if(user.getPhone() != null){
            textPhone.setText(user.getPhone());
        }
        if(user.getJobTitle() != null){
            textJobTitle.setText(user.getJobTitle());
        }
        if(user.getEmployer() != null){
            textEmployer.setText(user.getEmployer());
        }
        if(user.getOrganization() != null){
            textOrganizations.setText(user.getOrganization());
        }
        if(user.getState() != null){
            textState.setText(user.getState());
        }
        if(user.getZip() != null){
            textZip.setText(user.getZip());
        }
        if(user.getMajor() != null){
            textMajor.setText(user.getMajor());
        }
        if(user.getMinor() != null){
            textMinor.setText(user.getMinor());
        }
        if(user.getAreaOfStudy() != null){
            textAreaOfStudy.setText(user.getAreaOfStudy());
        }
        if(user.getResearchInterests() != null){
            textResearchInterests.setText(user.getResearchInterests());
        }
        if(user.getSkills() != null){
            textSkills.setText(user.getSkills());
        }

        button = (Button) findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = textTitle.getText().toString().trim();
                String firstName = textFirstName.getText().toString().trim();
                String lastName = textLastName.getText().toString().trim();
                String middleName = textMiddleName.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String password = user.getPassword();
                String phone = textPhone.getText().toString().trim();
                String jobTitle = textJobTitle.getText().toString().trim();
                String employer = textEmployer.getText().toString().trim();
                String organization = textOrganizations.getText().toString().trim();
                String state = textState.getText().toString().trim();
                String zip = textZip.getText().toString().trim();
                String major = textMajor.getText().toString().trim();
                String minor = textMinor.getText().toString().trim();
                String areaOfStudy = textAreaOfStudy.getText().toString().trim();
                String researchInterests = textResearchInterests.getText().toString().trim();
                String skills = textSkills.getText().toString().trim();

                account = new Users (title, firstName, middleName, lastName, email, password,
                        phone, jobTitle, employer, organization, state, zip, major, minor, areaOfStudy,
                        researchInterests, skills);

                dbHelper.updateUser(account);
                openUserProfile(currentEmail);
            }
        });
    }

    public void openUserProfile(String email) {
        Intent intentOpen = new Intent(this, Profile.class);
        intentOpen.putExtra("EMAIL_SESSION_ID", email);
        startActivity(intentOpen);
    }
}
