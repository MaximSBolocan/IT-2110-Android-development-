package com.example.m.onemainpage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int MESSAGE_REQUEST_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button printButton=(Button)findViewById(R.id.button);
        final TextView textPrinted =(TextView)findViewById(R.id.textView);

        final EditText  textEdit=(EditText)findViewById(R.id.editText);

        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textEdit.getText().toString();
                Intent sendMesage = new Intent();
                sendMesage.putExtra("MESAGE_DATA", message);
                setResult(Activity.RESULT_OK, sendMesage);
                finish();

            }
            public void getText(Intent data)
            {
                String newMessage=data.getStringExtra("MESAGE_DATA");
                textPrinted.setText(newMessage);
            }

        });

    }



    }

