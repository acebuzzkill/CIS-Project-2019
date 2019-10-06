package com.example.claremountconnection.ProfileLoginCreate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.claremountconnection.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class ProfileCreate extends AppCompatActivity {

    private TextInputLayout textInputLoginEmail;
    private TextInputLayout textInputLoginPassword;
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

        textInputLoginEmail = findViewById(R.id.text_input_login_email);
        textInputLoginPassword = findViewById(R.id.text_input_login_password);
    }

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

    public void confirmInput(View v) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        String input = "Email: " + textInputLoginEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputLoginPassword.getEditText().getText().toString();

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

}


