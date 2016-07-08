package com.example.pannam.sharedpreferencedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by pannam on 7/7/2016.
 */
public class ActivityB extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    TextView userNameTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        userNameTextView = (TextView) findViewById(R.id.editText3);
        passwordTextView = (TextView) findViewById(R.id.editText4);


    }

    public void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("My Data", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)) {
            Toast.makeText(this, "No Data ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "There is Data ", Toast.LENGTH_LONG).show();
            userNameTextView.setText(name);
            passwordTextView.setText(password);




        }


    }

    public void previous(View view) {
        Toast.makeText(this, "Previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
