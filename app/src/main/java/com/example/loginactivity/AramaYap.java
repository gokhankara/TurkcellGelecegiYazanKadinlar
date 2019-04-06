package com.example.loginactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AramaYap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arama_yap);

        final EditText telNo = (EditText) findViewById(R.id.txtTelNo);
        Button ara = (Button) findViewById(R.id.btnAra);

        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String numara = telNo.getText().toString();
             Intent aramaInten = new Intent(Intent.ACTION_DIAL);

            aramaInten.setData(Uri.parse("tel:"+numara));
            startActivity(aramaInten);

            }
        });

    }
}
