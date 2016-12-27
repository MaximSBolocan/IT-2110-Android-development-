package com.example.m.lab10_extracontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Tri_C extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tri__c);
        Intent secondIntent=getIntent();
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.tri-c.edu");
    }
}
