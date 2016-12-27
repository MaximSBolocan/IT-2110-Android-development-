package com.example.m.lab_02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button activityButton =(Button)findViewById(R.id.button);
        activityButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                Intent startIntent =new Intent(getApplicationContext(),Main2Activity.class);
                startIntent.putExtra("com.example.m.lab_02.MESSAGE","This is just a  Second Activity");
                startActivity(startIntent);
            }
        });
        Button webButton =(Button)findViewById(R.id.button2);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String webURI = "http://www.youtube.com";
                Uri web = Uri.parse(webURI);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, web);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

    }
}
