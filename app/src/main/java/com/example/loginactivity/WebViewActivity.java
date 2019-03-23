package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        WebView webview = (WebView) findViewById(R.id.tarayici);
       // webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://gelecegiyazanlar.turkcell.com.tr");
    }
}
