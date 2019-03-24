package com.example.loginactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        final TextView editTextSMS = (TextView) findViewById(R.id.sender_message);
        final TextView editTextTelefonNo = (TextView) findViewById(R.id.receiver_phone_number);

        btnSmsGonder = (Button) findViewById(R.id.send_sms_button);
        btnSmsGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), editTextTelefonNo.getText(), Toast.LENGTH_LONG).show();

                String smsMetni = editTextSMS.getText().toString();
                String telefonNo = editTextTelefonNo.getText().toString();

                Log.i("Bilgi", "Telefon No:  " + telefonNo);
                Log.i("Bilgi", "SMS Metni: " +smsMetni);
             //   Uri uri= Uri.parse("smsto:" + telefonNo);

             //  Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                //   intent.putExtra("smsbody", smsMetni);
             //   startActivity(intent);

             //   android.telephony.SmsManager sms=android.telephony.SmsManager.getDefault();
             //   sms.sendTextMessage(telefonNo, null, smsMetni, null, null);
            }
        });
    }
}
