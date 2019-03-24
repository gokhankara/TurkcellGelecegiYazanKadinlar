package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    Button butonHarita;
    Button butonWebSayfasi;
    Button butonOpenFotoAndVideo;
    Button buttonSesKayit;
    Button buttonSMSGonder;
    Button buttonAramayap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        butonHarita = (Button) findViewById(R.id.open_map);
        butonHarita.setOnClickListener((View.OnClickListener) this);

        butonWebSayfasi = (Button) findViewById(R.id.btnWebSayfasi);
        butonWebSayfasi.setOnClickListener((View.OnClickListener) this);

        butonOpenFotoAndVideo = (Button) findViewById(R.id.btnOpenFotoAndVideo);
        butonOpenFotoAndVideo.setOnClickListener((View.OnClickListener) this);

        buttonSesKayit = (Button) findViewById(R.id.btnSesKayit);
        buttonSesKayit.setOnClickListener((View.OnClickListener) this);

        buttonSMSGonder = (Button) findViewById(R.id.btnSmsGonder);
        buttonSMSGonder.setOnClickListener((View.OnClickListener) this);

        buttonAramayap = (Button) findViewById(R.id.btnAramaYap);
        buttonAramayap.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        if (view == butonHarita) {
            Intent intent = new Intent(Menu.this, map.class);
            startActivity(intent);
        }
        else if (view == butonWebSayfasi){
            Intent intent = new Intent(Menu.this, WebSayfasi.class);
            startActivity(intent);
        }
        else if(view == buttonAramayap) {
            Intent intent = new Intent(Menu.this, AramaYap.class);
            startActivity(intent);
        }
        else if (view == butonOpenFotoAndVideo){
            Intent intent = new Intent(Menu.this, FotoVeVideo.class);
            startActivity(intent);
        }
        else if(view == buttonSesKayit) {
            Intent intent = new Intent(Menu.this, SesKayit.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(Menu.this, SMSGonder.class);
            startActivity(intent);
        }
    }
}