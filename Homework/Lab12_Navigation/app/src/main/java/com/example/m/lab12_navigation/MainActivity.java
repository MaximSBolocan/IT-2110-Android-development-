package com.example.m.lab12_navigation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1= (Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Pages");
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                Intent startIntent=new Intent (getApplicationContext(),Main2Activity.class);
                startActivity(startIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent startIntent=new Intent (getApplicationContext(),Main3Activity.class);
                startActivity(startIntent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent startIntent=new Intent (getApplicationContext(),Main4Activity.class);
                startActivity(startIntent);
            }
        });

    }
}
