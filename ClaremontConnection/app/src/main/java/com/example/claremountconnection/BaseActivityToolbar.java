package com.example.claremountconnection;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.claremountconnection.Opportunities.Opportunities;
import com.example.claremountconnection.ProfileLogin;

import org.w3c.dom.Text;

public abstract class BaseActivityToolbar extends AppCompatActivity {

        Toolbar toolbar;
        protected abstract int getLayoutResource();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(getLayoutResource());
            configureToolbar();

            if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                // Hide Logout Button

            }
            else {
                // Show Logout Button
                final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
            }

        }

        private void configureToolbar() {
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.toolbar_menu, menu);

            if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                // Hide Logout Button
                MenuItem item = menu.findItem(R.id.menu_item11);
                item.setEnabled(false);
            }
            else {
                // Show Logout Button
                final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
            }

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_item1:
                    Intent intent1 = new Intent(this, NewsFeed.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent1);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent1.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent1);
                    }
                    break;
                case R.id.menu_item2:
                    Intent intent2 = new Intent(this, ProfileLogin.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent2);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent2.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent2);
                    }
                    break;
                case R.id.menu_item3:
                    Intent intent3 = new Intent(this, FindAlumni.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent3);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent3.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent3);
                    }
                    break;
                case R.id.menu_item4:
                    Intent intent4 = new Intent(this, Opportunities.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent4);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent4.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent4);
                    }
                    break;
                case R.id.menu_item5:
                    Intent intent5 = new Intent(this, Map.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent5);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent5.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent5);
                    }
                    break;
                case R.id.menu_item6:
                    Intent intent6 = new Intent(this, Messages.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent6);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent6.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent6);
                    }
                    break;
                case R.id.menu_item7:
                    Intent intent7 = new Intent(this, Options.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent7);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent7.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent7);
                    }
                    break;
                case R.id.menu_item8:
                    Intent intent8 = new Intent(this, MainActivity.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent8);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent8.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent8);
                    }
                    break;
                case R.id.menu_item9:
                    Intent intent9 = new Intent(this, TestDisplayDBUser.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent9);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent9.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent9);
                    }
                    break;
                case R.id.menu_item10:
                    Intent intent10 = new Intent(this, Recommender.class);
                    if (getIntent().getStringExtra("EMAIL_SESSION_ID") == null) {
                        // Hide Logout Button
                        this.startActivity(intent10);
                    }
                    else {
                        // Show Logout Button
                        final String currentEmail = getIntent().getStringExtra("EMAIL_SESSION_ID");
                        intent10.putExtra("EMAIL_SESSION_ID", currentEmail);
                        this.startActivity(intent10);
                    }
                    break;
                case R.id.menu_item11:
                    Intent intent11 = new Intent(this, Logout.class);
                    // this tab will reset the current email cookie
                    this.startActivity(intent11);
                    break;

                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }
    }

