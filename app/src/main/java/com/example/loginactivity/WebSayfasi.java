package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebSayfasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_sayfasi);

        WebView wv = (WebView) findViewById(R.id.webViewKontrolu);

        wv.loadUrl("https://gelecegiyazanlar.turkcell.com.tr/");
    }
}
