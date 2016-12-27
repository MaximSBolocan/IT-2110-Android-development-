package com.example.m.lab04lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {
  Button sendMessageButton;
  Button cancelButton;
  EditText messageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        messageEditText= (EditText)findViewById(R.id.editText);
        sendMessageButton= (Button)findViewById(R.id.buttonSend);
        sendMessageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message=messageEditText.getText().toString();
                Intent result =new Intent();
                result.putExtra("MESSAGE_DATA",message);
                setResult(Activity.RESULT_OK,result);
                finish();
            }
        });
        cancelButton=(Button)findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
