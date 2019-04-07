package com.example.loginactivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.IslamicCalendar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Anasayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button btnHesap = (Button) findViewById(R.id.btnHesapla);
        btnHesap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
             Log.i("Bilgi","Hesapla Butonuna tıklandı");

                EditText txtkilo = (EditText) findViewById(R.id.txtKilo);
                EditText txtboy = (EditText) findViewById(R.id.txtBoy);
                TextView txtSonuc = (TextView) findViewById(R.id.txtSonuc);

                calculate(txtkilo,txtboy,txtSonuc);

            }
        });
    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_home :
                    Toast.makeText(Anasayfa.this, "Anasayfaya tıklandı", Toast.LENGTH_SHORT).show();
                break;

                case R.id.navigation_health :
                    Toast.makeText(Anasayfa.this, "sağlık menüsüne Tıklandı", Toast.LENGTH_SHORT).show();
                    break;

                    case R.id.navigation_diet :
            Toast.makeText(Anasayfa.this, "Diet menüsüne tıklandı", Toast.LENGTH_SHORT).show();

                    break;
            }
                return  true;
        }
    };



    private void calculate(EditText userWeightEt,EditText userLengthtEt,TextView userResultTv) {

        if (userWeightEt.getText().toString().length() > 0 && userLengthtEt.getText().toString().length() > 0) {

            Log.i("Bilgi", "calculate: Hesaplama başlıyor...");


            float userWeight = Float.parseFloat(userWeightEt.getText().toString());
            float userLength = Float.parseFloat(userLengthtEt.getText().toString());
            if(userLength>0){
                userLength = userLength / 100;
                float result = (userWeight / ((userLength * userLength)));

                String resultDescription = "";

                if (result < 15) {
                    resultDescription = "Aşırı Zayıf";
                } else if (result > 15 && result <= 30) {
                    resultDescription = "Zayıf";
                } else if (result > 30 && result <= 40) {
                    resultDescription = "Normal";
                } else if (result > 40) {
                    resultDescription = "Aşırı Şişman (Morbid Obez)";
                } else {
                    resultDescription = "Aşırı Şişman (Morbid Obez)";
                }
                Log.i("Bilgi", "Sonuc: " + resultDescription);
                userResultTv.setText("Vücut kitle endeksiniz: " + result + "\n" + resultDescription);
            }}
            else {

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Hata!");
            builder.setMessage("Kilo ya da boy boş bırakılamaz.");
            builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            builder.show();
        }
    }
}
