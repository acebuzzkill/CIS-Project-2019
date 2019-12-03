package com.example.claremountconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class ProfileCreate extends AppCompatActivity {

    DatabaseHelper db;
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

    private TextInputLayout textInputLoginEmail;
    private TextInputLayout textInputLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_create);
        db = new DatabaseHelper(this);

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
        } else if (!db.checkemail(emailInput)) {
            textInputLoginEmail.setError("This email already exists");
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


    // Enter insert account email and pw here
    // Start edit profile activity
    public void confirmInput(View v) {
        if (validateEmail() && validatePassword()) {
            addInput();
            String emailInput = textInputLoginEmail.getEditText().getText().toString().trim();
            startProfileEdit(emailInput);
        }
    }

    public void addInput() {
        String emailInput = textInputLoginEmail.getEditText().getText().toString().trim();
        String passwordInput = textInputLoginPassword.getEditText().getText().toString().trim();
        db.insert(emailInput, passwordInput);
    }

    public void startProfileEdit(String email) {
        Intent intent = new Intent(this, ProfileEdit.class);
        intent.putExtra("EMAIL_SESSION_ID", email);
        this.startActivity(intent);
        closeKeyboard();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}


