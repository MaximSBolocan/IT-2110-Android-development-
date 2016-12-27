package com.example.m.lab12_navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent newIntent=getIntent();
        WebView myWebView = (WebView) findViewById(R.id.web1);
        myWebView.loadUrl("http://www.google.com");
    }
}
