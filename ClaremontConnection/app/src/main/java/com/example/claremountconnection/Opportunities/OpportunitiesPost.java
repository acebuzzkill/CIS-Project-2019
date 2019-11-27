package com.example.claremountconnection.Opportunities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.claremountconnection.R;

public class OpportunitiesPost extends AppCompatActivity {

    private Button buttonPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities_post);

        buttonPost = (Button) findViewById(R.id.button_post);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpportunities();
            }
        });
    }

    public void openOpportunities() {
        Intent intent = new Intent(this, Opportunities.class);
        startActivity(intent);
    }
}
