package com.example.a8smspractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS},0);

    }
    public void onSend(View v){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
            EditText number=(EditText) findViewById(R.id.number);
            EditText message=(EditText) findViewById(R.id.message);
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(number.getText().toString(),"7358223523",message.getText().toString(),null,null);
            Toast.makeText(this,"Sent",Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS},0);
        }

    }
    public void onReceive(View v){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_SMS},0);

    }
}