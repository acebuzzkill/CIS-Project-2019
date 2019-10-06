package com.example.claremountconnection.ProfileHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.ProfileEdit;
import com.example.claremountconnection.R;

public class Profile extends BaseActivityToolbar {

    private static final String TAG = "Profile";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button = (Button) findViewById(R.id.button_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileEdit();
            }
        });
    }
    public void openProfileEdit() {
        Intent intent = new Intent(this, ProfileEdit.class);
        startActivity(intent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile;
    }
}