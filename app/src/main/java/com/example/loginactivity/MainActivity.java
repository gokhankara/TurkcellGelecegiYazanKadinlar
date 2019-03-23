package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void GirisYap(View view) {


        EditText kullaniciAdi = (EditText)findViewById(R.id.txtKullaniciAdi);

        String logKullaniciAdi = kullaniciAdi.getText().toString();


        Log.i("Bilgi", "Giris Yap method'u çalışmasına başlıyor...");
      //  EditText editText = (EditText)findViewById(R.id.txtKullaniciAdi);
        EditText txtParola = (EditText)findViewById(R.id.txtParola);

        Log.e("Bilgi", "Kullanıcı 'Kullanıcı Adı' olarak " + logKullaniciAdi + " girdi.");
        Log.e("Bilgi", "Kullanıcı 'Kullanıcı Adı' olarak " + kullaniciAdi.getText().toString() + " girdi.");
        Log.e("Bilgi", "Kullanıcı 'Parola' olarak " + txtParola.getText() + " girdi.");

        Log.i("Bilgi", "Kullanıcının Bilgileri sistemde olup olmadığı kontrol ediliyor..");

        EditText yeniKullaniciAdi = (EditText)findViewById(R.id.txtKullaniciAdi);
        String kulAdi = yeniKullaniciAdi.getText().toString();

        Log.i("Bilgi", "Main Activity burada bitmiştir... ");

        Intent hosgeldinizActivity = new Intent(this, Menu.class);
        hosgeldinizActivity.putExtra("MainActivityKullaniciAdi",kulAdi);
        startActivity(hosgeldinizActivity);


    //    Intent intent = new Intent(this, LoginSuccess.class);
    //    startActivity(intent);
        }

    public void OpenMapActivty(View view) {
        Log.i("Bilgi", "OpenMap methodu çalışmaya başladı... ");
        Intent mapIntent = new Intent(this, map.class);
        Log.i("Bilgi", "Intent Class'ı oluşturuldu... ");
        startActivity(mapIntent);
    }

    public void OpenMapActivti(View view) {
    }
}
