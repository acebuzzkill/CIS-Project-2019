package com.example.claremountconnection.Opportunities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.Opportunity;
import com.example.claremountconnection.R;

public class OpportunitiesDetailsPage extends AppCompatActivity {

    private TextView subject;
    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities_details_page);

        subject = findViewById(R.id.subject);
        detail = findViewById(R.id.detail);

        final String opportunityIdStr = getIntent().getStringExtra("OPPORTUNITY_SESSION_ID");
        DatabaseHelper dbhelper = new DatabaseHelper(this);
        Opportunity opportunity = new Opportunity();

        opportunity = dbhelper.getOpportunity(opportunityIdStr);

        subject.setText("Subject: " + opportunity.getPost());
        detail.setText("Skill Preferred: " + opportunity.getSkill() + " \n\n"
                        + "Contact: " + opportunity.getContact());
    }
}
