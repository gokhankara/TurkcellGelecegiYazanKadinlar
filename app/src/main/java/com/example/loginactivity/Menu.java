package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    Button butonHarita;
    Button butonWebSayfasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        butonHarita = (Button) findViewById(R.id.open_map);
        butonHarita.setOnClickListener((View.OnClickListener) this);

        butonWebSayfasi = (Button) findViewById(R.id.btnWebSayfasi);
        butonWebSayfasi.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view == butonHarita) {
            Intent hariteIntent = new Intent(Menu.this, map.class);
            startActivity(hariteIntent);
        }
        else if (view == butonWebSayfasi){
            Intent webSayfasiInten = new Intent(Menu.this, WebSayfasi.class);
            startActivity(webSayfasiInten);
        }
    }
}