package com.example.claremountconnection.ProfileLoginCreate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.claremountconnection.DatabaseHelper2;
import com.example.claremountconnection.ProfileEdit;
import com.example.claremountconnection.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class ProfileCreate extends AppCompatActivity {
    DatabaseHelper2 db;

    private TextInputLayout textInputLoginEmail;
    private TextInputLayout textInputLoginPassword;
    private TextInputLayout textInputLoginConfirmPassword;

    private TextInputEditText textLoginEmail;
    private TextInputEditText textLoginPassword;
    private TextInputEditText textLoginConfirmPassword;

    private Button buttonNewProfile;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    //"(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_create);

        db = new DatabaseHelper2(this);

        textLoginEmail = (TextInputEditText)findViewById(R.id.text_login_email);
        textLoginPassword = (TextInputEditText)findViewById(R.id.text_login_password);
        textLoginConfirmPassword = (TextInputEditText)findViewById(R.id.text_login_confirm_password);

        buttonNewProfile = (Button) findViewById(R.id.profile_create_button);
        buttonNewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfile();
            }
        });
            /**
            @Override
            public void onClick(View v) {
                String s1 = textLoginEmail.getText().toString();
                String s2 = textLoginPassword.getText().toString();
                String s3 = textLoginConfirmPassword.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                if (!s2.equals(s3)) {
                    textLoginConfirmPassword.setError("Email does not match");
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(s1).matches()){
                    textLoginEmail.setError("Not a valid email address");
                }
                if (!PASSWORD_PATTERN.matcher(s2).matches()) {
                    textLoginPassword.setError("Password too weak");
                }else {
                    if (s2.equals(s3)) {
                        Boolean checkemail = db.checkemail(s1);
                        if (checkemail == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });
        */
    }

    public void openEditProfile() {
        Intent intent = new Intent(this, ProfileEdit.class);
        startActivity(intent);
    }
}
    /**
    private boolean validateEmail() {
        String emailInput = textInputLoginEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputLoginEmail.setError("Email field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputLoginEmail.setError("Not a valid email address");
            return false;
        } else {
            textInputLoginEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputLoginPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputLoginPassword.setError("Password field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputLoginPassword.setError("Password too weak");
            return false;
        } else {
            textInputLoginPassword.setError(null);
            return true;
        }
    }
    */



