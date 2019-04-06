package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SesKayit extends AppCompatActivity implements View.OnClickListener {

    Button btnKaydet;
    Button btnDurdur;
    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ses_kayit);

        btnKaydet = (Button) findViewById(R.id.btnKaydet);
        btnKaydet.setOnClickListener((View.OnClickListener) this);

        btnDurdur = (Button) findViewById(R.id.btnDurdur);
        btnDurdur.setOnClickListener((View.OnClickListener) this);

        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnKaydet) {
            Toast.makeText(getApplicationContext(), btnKaydet.getText(), Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(Menu.this, map.class);
            // startActivity(intent);
            SesKaydet();
        }
        else if (view == btnDurdur) {
            Toast.makeText(getApplicationContext(), btnDurdur.getText(), Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(Menu.this, map.class);
            // startActivity(intent);
            SesDurdur();
        }
        else if (view == btnCal) {
            Toast.makeText(getApplicationContext(), btnCal.getText(), Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(Menu.this, map.class);
            // startActivity(intent);
            SesCal();
        }
    }

    private void SesCal() {
    }

    private void SesDurdur() {
    }

    private void SesKaydet() {

    }


}