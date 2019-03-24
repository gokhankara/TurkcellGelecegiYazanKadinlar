package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SMSGonder extends AppCompatActivity {


    Button btnSmsGonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsgonder);

        TextView editTextSMS = (TextView) findViewById(R.id.sender_message);
        TextView editTextTelefonNo = (TextView) findViewById(R.id.receiver_phone_number);

        btnSmsGonder = (Button) findViewById(R.id.send_sms_button);
        btnSmsGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "SMS Gönderilyor...", Toast.LENGTH_LONG).show();
            }
        });
    }
}
