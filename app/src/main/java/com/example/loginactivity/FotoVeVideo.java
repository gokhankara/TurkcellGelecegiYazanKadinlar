package com.example.loginactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class FotoVeVideo extends AppCompatActivity {

    Button btnFotoCek;
    Button btnVideoCek;

    private static final int VIDEO_ACTION_CODE = 101;
    private static final int IMAGE_ACTION_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_ve_video);

        btnFotoCek = (Button) findViewById(R.id.btnFotoCek);
        btnVideoCek = (Button) findViewById(R.id.btnVideoCek);

        btnFotoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viw){
                Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(fotoIntent);
            }
        });

        btnVideoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viw){
                Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(videoIntent);
            }
        });
    }

    @Override
    public void onActivityResult(int istekKodu, int sonucKodu, Intent data){
        super.onActivityResult(istekKodu,sonucKodu,data);

        if (sonucKodu != RESULT_OK) return;

        switch (istekKodu){

            case VIDEO_ACTION_CODE:
                VideoView videoView = (VideoView) findViewById(R.id.videoViewOnizleme);
                videoView.setVideoURI(data.getData());
                videoView.setMediaController(new MediaController(this));
                videoView.requestFocus();
                videoView.start();
            break;
            case IMAGE_ACTION_CODE:
                Bundle extras = data.getExtras();
                ((ImageView)findViewById(R.id.imgViewOnizleme)).setImageBitmap((Bitmap) extras.get("data"));
            break;
            default :
                break;
        }

    }
}
