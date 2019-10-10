package com.example.claremountconnection.ProfileLoginCreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.DatabaseHelper2;
import com.example.claremountconnection.ProfileHome.Profile;
import com.example.claremountconnection.R;

public class ProfileLogin extends AppCompatActivity {

    private EditText textUserEmail;
    private EditText textUserPassword;
    private Button buttonEnter;
    private Button buttonCreate;
    DatabaseHelper2 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);

        db = new DatabaseHelper2(this);

        textUserEmail = findViewById(R.id.text_user_email);
        textUserPassword = findViewById(R.id.text_user_password);
        buttonEnter = findViewById(R.id.button_user_enter);
        /**
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserProfile();
            }
        });
        */
        buttonCreate = findViewById(R.id.button_user_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileCreate();
            }
        });

        textUserEmail.addTextChangedListener(loginTextWatcher);
        textUserPassword.addTextChangedListener(loginTextWatcher);


    }

    public void openUserProfile() {
        Intent intentOpen = new Intent(this, Profile.class);
        startActivity(intentOpen);
        closeKeyboard();
    }

    public void openProfileCreate() {
        Intent intent = new Intent(this, ProfileCreate.class);
        startActivity(intent);
        closeKeyboard();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = textUserEmail.getText().toString().trim();
            String passwordInput = textUserPassword.getText().toString().trim();

            buttonEnter.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
