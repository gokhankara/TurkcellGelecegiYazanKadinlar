package com.example.loginactivity;

import android.app.Person;

public class Personel {

    private String isim;
    private String soyisim;
    private String unvan;
    private String tel;

    public Personel(String isim, String soyisim, String unvan, String tel){
        this.isim = isim;
        this.soyisim = soyisim;
        this.unvan = unvan;
        this.tel=tel;
    }

    public Personel(String isim, String soyisim, String unvan){
        this.isim = isim;
        this.soyisim = soyisim;
        this.unvan = unvan;

        isim= "Merhaba " + isim;

    }

    public float Getir (){

        int a = 5;
        int b = 4;

        return a/b;
    }

    public void Getir2 (){

        int a = 5;
        int b = 4;
    }

    public void Getir3 (){

        int a = 5;
        int b = 4;
    }
}
