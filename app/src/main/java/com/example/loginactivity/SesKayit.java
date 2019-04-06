package com.example.loginactivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SesKayit extends AppCompatActivity implements View.OnClickListener {

    Button btnKaydet;
    Button btnDurdur;
    Button btnCal;

    MediaPlayer player;
    MediaRecorder recorder;
    String kayitYolu= Environment.getExternalStorageDirectory().getPath()+"/kayit.3gp";

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
            Log.i("Bilgi", "Kaydet Çaışıyor");
            Toast.makeText(getApplicationContext(), btnKaydet.getText(), Toast.LENGTH_LONG).show();

            if (YetkiKontrouYap()){
                Log.i("Bilgi", "Yetki Başarılı");
                SesKaydet();
            }
            else  {
                Log.i("Bigi", "Yetki Başarısız");
                YetkiIste();
                SesKaydet();
            }


        }
        else if (view == btnDurdur) {
            SesDurdur();
        }
        else if (view == btnCal) {
            SesCal();
        }
    }

    @Override
    public void onRequestPermissionsResult(int reqestCode, String[] permissons, int[] grantResuts){
        switch (reqestCode) {
            case 200:
                if(grantResuts.length>0){
                    boolean kayitIcinİzin = permissons[0].equals(PackageManager.PERMISSION_GRANTED);
                    boolean saklamakIcinİzin = permissons[1].equals(PackageManager.PERMISSION_GRANTED);
                    if ( kayitIcinİzin &&  saklamakIcinİzin) {
                        Toast.makeText(getApplicationContext(), "Yetki veridi.", Toast.LENGTH_LONG).show();
                    }
                        else  {
                            Toast.makeText(getApplicationContext(), "Yetki verilemedi.", Toast.LENGTH_LONG).show();
                        }
                    }
                break;
                }
    }


    private void YetkiIste() {
        ActivityCompat.requestPermissions(SesKayit.this,new String[]{RECORD_AUDIO,WRITE_EXTERNAL_STORAGE},200);
    }

    private boolean YetkiKontrouYap() {
      int hariciDepoamaKontrolu = ContextCompat.checkSelfPermission(getApplicationContext(),WRITE_EXTERNAL_STORAGE);
      int sesKayitKontrolu = ContextCompat.checkSelfPermission(getApplicationContext(),RECORD_AUDIO);

      return hariciDepoamaKontrolu == PackageManager.PERMISSION_GRANTED && sesKayitKontrolu ==PackageManager.PERMISSION_GRANTED;
    }


    private void SesKaydet() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(kayitYolu);

        try {
            Toast.makeText(getApplicationContext(), "Kayıt için hazırlanıyor...", Toast.LENGTH_LONG).show();
            recorder.prepare();
            recorder.start();
            Toast.makeText(getApplicationContext(), "Kayıt Yapılıyor...", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SesCal() {
        player = new MediaPlayer();
        player.setVolume(1.0f, 1.0f);

        try {
            player.setDataSource(kayitYolu);
            player.prepare();
            player.start();
            Toast.makeText(getApplicationContext(), "Kayıt Çalınıyor...", Toast.LENGTH_LONG).show();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    player.release();
                    player = null;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SesDurdur() {
        Log.i("Bilgi","Durdurma Başlıyor...");
        //Toast.makeText(getApplicationContext(), "Durduruldu", Toast.LENGTH_LONG).show();

        if (recorder != null){
            recorder.stop();
            Log.i("Bilgi","stop...");
            recorder.reset();
            Log.i("Bilgi","reset...");
            recorder.release();
            Log.i("Bilgi","release...");
            recorder = null;
        }
        else    {
            Log.i("Bilgi","recorder = null");
        }
    }

              
}