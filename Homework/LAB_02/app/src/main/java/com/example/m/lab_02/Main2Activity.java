package com.example.m.lab_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent  intent =getIntent();
        String message=intent.getStringExtra("com.example.m.lab_02.MESSAGE");
        TextView messageTextView =(TextView) findViewById(R.id.textView2);
        messageTextView.setText(message);



    }


}
