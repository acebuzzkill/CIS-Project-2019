package com.example.claremountconnection;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.claremountconnection.ProfileLogin;

public abstract class BaseActivityToolbar extends AppCompatActivity {

        Toolbar toolbar;
        protected abstract int getLayoutResource();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(getLayoutResource());
            configureToolbar();
        }

        private void configureToolbar() {
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.toolbar_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_item1:
                    Intent intent1 = new Intent(this, NewsFeed.class);
                    this.startActivity(intent1);
                    break;
                case R.id.menu_item2:
                    Intent intent2 = new Intent(this, ProfileLogin.class);
                    this.startActivity(intent2);
                    break;
                case R.id.menu_item3:
                    Intent intent3 = new Intent(this, FindAlumni.class);
                    this.startActivity(intent3);
                    break;
                case R.id.menu_item4:
                    Intent intent4 = new Intent(this, Opportunities.class);
                    this.startActivity(intent4);
                    break;
                case R.id.menu_item5:
                    Intent intent5 = new Intent(this, Map.class);
                    this.startActivity(intent5);
                    break;
                case R.id.menu_item6:
                    Intent intent6 = new Intent(this, Messages.class);
                    this.startActivity(intent6);
                    break;
                case R.id.menu_item7:
                    Intent intent7 = new Intent(this, Options.class);
                    this.startActivity(intent7);
                    break;
                case R.id.menu_item8:
                    Intent intent8 = new Intent(this, MainActivity.class);
                    this.startActivity(intent8);
                    break;

                case R.id.menu_item9:
                    Intent intent9 = new Intent(this, TestDisplayDBUser.class);
                    this.startActivity(intent9);
                    break;

                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }
    }

