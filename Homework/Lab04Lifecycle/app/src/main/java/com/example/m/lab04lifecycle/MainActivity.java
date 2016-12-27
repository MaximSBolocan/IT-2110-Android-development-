package com.example.m.lab04lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public final static int MESSAGE_REQUEST_CODE=0;
    TextView messageTextView;
    Button getMessageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("My filter ", "onCreate()called");
        messageTextView = (TextView) findViewById(R.id.textView);
        Log.d("My filter","Text View is created ");
        getMessageButton = (Button) findViewById(R.id.button);
        Log.d("My filter","Button is created");
        getMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getResult = new Intent(getApplicationContext(), Page2.class);
                Log.d("My filter ","the Intent is created");
                startActivityForResult(getResult, MESSAGE_REQUEST_CODE);
            }
        });
    }
        @Override
                protected void onActivityResult( int requestcode,int resultcode, Intent data)
        {
            if (requestcode==MESSAGE_REQUEST_CODE)

            {
                if(resultcode==Activity.RESULT_OK)
                {
                    String message=data.getStringExtra("MESSAGE_DATA");
                    messageTextView.setText(message);
                }
            }
        }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("my filter","onStart() methode called" );
    };
    @Override
    protected void onStop()
        {
            super.onStop();
            Log.d("My filter", "onstop() methode called");
        }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("My filter ","onPause() created");
    }

}
