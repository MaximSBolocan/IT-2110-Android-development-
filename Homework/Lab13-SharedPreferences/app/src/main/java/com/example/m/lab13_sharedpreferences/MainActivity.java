package com.example.m.lab13_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText userNameInput;
    EditText nameInput;
EditText passwordInput;
    Button button;
    public String uName;
    public String uPassword;
    public String uUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameInput=(EditText) findViewById(R.id.userName);
        nameInput=(EditText)findViewById(R.id.name);
        passwordInput=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view )
            {
                SharedPreferences sharedPref =getSharedPreferences("userInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putString("nameOut",nameInput.getText().toString());
                editor.putString("userNameOut",userNameInput.getText().toString());
                editor.putString("passwordOut",passwordInput.getText().toString());
                editor.apply();
                Intent startIntent =new Intent(getApplicationContext(),Page2.class);

                startActivity(startIntent);

            }
        });
    }
}
