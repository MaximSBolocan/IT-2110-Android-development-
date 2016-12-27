package com.example.m.hour5application;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import java.util.Random;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DelayIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public  static final String ACTION_DELAY = "com.example.m.hour5application.action.DELAY";
    public  static final String EXTRA_MESSAGE = "com.example.m.hour5application.action.MESSAGE";
    public DelayIntentService() {
        super("DelayIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent)
    {
        SystemClock.sleep(randomNumber());
        Intent broadcastIntent =new Intent();
        broadcastIntent.setAction(ACTION_DELAY);
        broadcastIntent.putExtra(EXTRA_MESSAGE,"Update :using Intent Service");
        sendBroadcast(broadcastIntent);
    }
    protected int randomNumber()
    {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(15000)+1;
        Log.d("generated",Integer.toString(randomInt));
        return randomInt;

    }

}
