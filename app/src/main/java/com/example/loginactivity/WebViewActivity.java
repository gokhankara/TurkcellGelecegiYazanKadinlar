package com.example.loginactivity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        WebView webView = (WebView) findViewById(R.id.tarayici);
       // webView.getSettings().setJavaScriptEnabled(true);


        // Sayfanın yüklendiğinin anlaşılması için ProgressDialog açıyoruz.
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Asistan'ım",
                "Sayfa Yükleniyor...", true);

        webView.setWebViewClient(new WebViewClient() {

            // Sayfanın yüklenme işlemi bittiğinde progressDialog'u kapatıyoruz.
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        });

        webView.loadUrl("https://gelecegiyazanlar.turkcell.com.tr");

    }
}
