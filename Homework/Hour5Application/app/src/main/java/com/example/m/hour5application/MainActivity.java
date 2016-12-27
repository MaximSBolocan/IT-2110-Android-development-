package com.example.m.hour5application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button uiThreadButton;
    Button postButton;
    Button asyncTaskButton;
    Button intentServiceButton;
    TextView resultTextView;
    DelayReceiver delayReceiver=new DelayReceiver();
    ;


protected int randomNumber()
{
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(15000)+1;
    Log.d("generated",Integer.toString(randomInt));
    return randomInt;

}





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView=(TextView)findViewById(R.id.textView);
        uiThreadButton=(Button)findViewById(R.id.uiThreadButton);
        uiThreadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SystemClock.sleep(randomNumber());
                resultTextView.setText("Updated on UI Thread ");
                Log.d("Generated : ","using UI ");
            }
        });
        postButton=(Button)findViewById(R.id.postButton);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(randomNumber());
                        resultTextView.post(new Runnable() {
                            @Override
                            public void run() {
                                resultTextView.setText("Updated using post");
                                Log.d("Generated : ","using post ");

                            }
                        });
                    }
                }).start();
            }
        });
        asyncTaskButton=(Button)findViewById(R.id.asyncTaskButton);
        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DelayTask().execute();
                Log.d("Generated : ","using task ");
            }
        });
        intentServiceButton =(Button)findViewById(R.id.intentServiceButton);
        intentServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delayIntent=new Intent(getApplicationContext(),DelayIntentService.class);
                startService(delayIntent);
            }
        });

    }
    @Override
    protected void onResume()
    {
        super.onResume();;
        registerReceiver(delayReceiver,new IntentFilter(DelayIntentService.ACTION_DELAY) );
    }
    @Override
    protected void onPause()
    {
    super.onPause();
    unregisterReceiver(delayReceiver);
    }
    class DelayTask extends AsyncTask<Integer,Integer,Integer>
    {
        @Override
        protected void onPreExecute()
        {
            resultTextView.setText("Start Activity");
        }
        @Override
        protected void onPostExecute(Integer result)
        {
            if(result==0){
                resultTextView.setText("Updated via AsyncTask");
            }
        }
        @Override
        protected Integer doInBackground(Integer...params ){
            SystemClock.sleep(randomNumber());
            return 0;
        }
    }
    public class DelayReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context,Intent intent)
        {
            if (intent.getAction().equals(DelayIntentService.ACTION_DELAY)){
                String message =intent.getExtras().getString(DelayIntentService.EXTRA_MESSAGE);
                resultTextView.setText(message);
            }
        }
    }
}
