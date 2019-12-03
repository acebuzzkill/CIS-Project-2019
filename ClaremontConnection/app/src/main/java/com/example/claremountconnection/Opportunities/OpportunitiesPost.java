package com.example.claremountconnection.Opportunities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.Opportunity;
import com.example.claremountconnection.R;

public class OpportunitiesPost extends AppCompatActivity {

    private Button buttonPost;
    private EditText subjectEdit;
    private EditText detailEdit;

    DatabaseHelper dbhelper = new DatabaseHelper(this);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities_post);

        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");

        // take text from editor and populate the database

        subjectEdit = findViewById(R.id.edit_subject);
        detailEdit = findViewById(R.id.edit_detail);

        buttonPost = (Button) findViewById(R.id.button_post);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                String subject = subjectEdit.getText().toString().trim();
                String skill = detailEdit.getText().toString().trim();
                String contact = currentEmail;
                System.out.println(subject);
                System.out.println(skill);
                System.out.println(contact);
                addOpportunityToDB(subject, skill, contact);
                openOpportunities();
            }
        });



    }

    public void openOpportunities() {
        Intent intent = new Intent(this, Opportunities.class);
        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
        intent.putExtra("EMAIL_SESSION_ID", currentEmail);
        startActivity(intent);
    }

    public void addOpportunityToDB(String post, String skill, String contact) {
        Opportunity opportunity = new Opportunity(post, skill, contact);
        DatabaseHelper dbhelper = new DatabaseHelper(this);
        System.out.println("post: " + post);
        System.out.println("skill: " + skill);
        System.out.println("contact: " + contact);
        System.out.println("post: " + opportunity.getPost());
        System.out.println("skill: " + opportunity.getSkill());
        System.out.println("contact: " + opportunity.getContact());
        dbhelper.addOpportunity(opportunity);
    }
}


