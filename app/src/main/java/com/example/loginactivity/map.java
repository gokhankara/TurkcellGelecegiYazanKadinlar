package com.example.loginactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Log.i("Bilgi", "Map Class çalışmaya başladı... ");
    }

    public void OpenMap(View view) {
        //41,00527	28,97696
      Uri geolocation =  Uri.parse("geo:41,00527,28,97696");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geolocation);

        startActivity(intent);
    }
}
