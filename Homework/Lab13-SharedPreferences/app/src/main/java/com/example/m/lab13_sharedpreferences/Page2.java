package com.example.m.lab13_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.id.message;

public class Page2 extends AppCompatActivity {
TextView userNameOut;
    TextView NameOut;
    TextView PasswordOut;
    String name;
    String username;
    String password;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Intent intent=getIntent();
        NameOut=(TextView)findViewById(R.id.name);
        userNameOut=(TextView) findViewById(R.id.userName);
        PasswordOut=(TextView)findViewById(R.id.password);
        pref=getApplication().getSharedPreferences("userInfo", MODE_PRIVATE);
        name=pref.getString("nameOut","");
        username=pref.getString("userNameOut","");
        password=pref.getString("passwordOut","");
        userNameOut.setText(username);
        NameOut.setText(name);
        PasswordOut.setText(password);

    }
}
