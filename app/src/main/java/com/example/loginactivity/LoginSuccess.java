package com.example.loginactivity;

import android.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class LoginSuccess extends AppCompatActivity {

    String[] ulkeler = {"Türkiye", "Almanya","İtalya", "Estonya","Litvanya","Romanya", "Rusya","Ahmet","Mehmet", "Osman","Ahmet","Mehmet", "Osman" } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Log.i("Bilgi", "Login Success Activity burada başlıyor... ");

        Bundle getBundle = getIntent().getExtras();
        String gelenDeger = getBundle.getString("MainActivityKullaniciAdi");

        TextView merhaba =  (TextView)findViewById(R.id.txtKarsilamaMesajiMerhaba);
        TextView KarsilamaMerhaba =  (TextView)findViewById(R.id.txtKarsilamaMesaji);


        Log.i("Bilgi", "Gelen Değer: " + gelenDeger);

        merhaba.setText(gelenDeger);
        String sabitMetin = KarsilamaMerhaba.getText().toString();

        KarsilamaMerhaba.setText(sabitMetin + " " + gelenDeger);

        ListView lstIller = (ListView)findViewById(R.id.lstOgrenciler);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler);

        lstIller.setAdapter(dataAdapter);


        Personel calican = new Personel
                ("Ahmet","Osmanoğlu","Terzi","05417789878");

        Personel calican2 = new Personel
                ("Ahmet","Osmanoğlu","Terzi");

  
    /*
        isimler[3].toString();
        String degerlerToplami= "";

        for (int i = 0; i<isimler.length; i++){
          degerlerToplami += isimler[i].toString();
          degerlerToplami = degerlerToplami +  isimler[i].toString();
        }

        KarsilamaMerhaba.setText(degerlerToplami);
        */
    }
}
