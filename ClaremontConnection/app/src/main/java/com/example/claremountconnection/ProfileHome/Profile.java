package com.example.claremountconnection.ProfileHome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.claremountconnection.BaseActivityToolbar;
import com.example.claremountconnection.R;

public class Profile extends BaseActivityToolbar {

    private static final String TAG = "Profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile;
    }


}