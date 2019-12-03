package com.example.claremountconnection;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class TestDisplayDBUser extends BaseActivityToolbar {

    private TextView textViewName;
    private List<Users> nameList;

    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textViewName = findViewById(R.id.text_view_name);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        nameList = dbHelper.getAllUsers();
        user = nameList.get(0);
        textViewName.setText("success: \n" +
                user.getFirstName());
        }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_test_display_dbuser;
    }
}
