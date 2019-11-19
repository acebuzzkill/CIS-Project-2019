package com.example.claremountconnection;

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
import android.widget.Toast;

import com.example.claremountconnection.DatabaseHelper;
import com.example.claremountconnection.ProfileHome.Profile;
import com.example.claremountconnection.R;

public class ProfileLogin extends AppCompatActivity {

    private String email;

    private EditText textUserEmail;
    private EditText textUserPassword;
    private Button buttonEnter;
    private Button buttonCreate;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);
        db = new DatabaseHelper(this);

        textUserEmail = (EditText) findViewById(R.id.text_user_email);
        textUserPassword = (EditText) findViewById(R.id.text_user_password);
        buttonEnter = (Button) findViewById(R.id.button_user_enter);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textUserEmail.getText().toString();
                String password = textUserPassword.getText().toString();
                Boolean checkemailPassword = db.emailPassword(email,password);
                if(checkemailPassword==true) {
                    Toast.makeText(getApplicationContext(), "You have logged in", Toast.LENGTH_SHORT).show();
                    openUserProfile(email);
                }
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });
        
        buttonCreate = (Button)findViewById(R.id.button_user_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileCreate();
            }
        });

        textUserEmail.addTextChangedListener(loginTextWatcher);
        textUserPassword.addTextChangedListener(loginTextWatcher);
    }

    public void openUserProfile(String email) {
        this.email = email;
        Intent intentOpen = new Intent(this, Profile.class);
        intentOpen.putExtra("EMAIL_SESSION_ID", email);
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
