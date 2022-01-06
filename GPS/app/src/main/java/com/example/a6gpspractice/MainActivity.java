package com.example.a6gpspractice;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 10, this);
    }
    public void onSearchName(View v){
        EditText name=(EditText) findViewById(R.id.place);
        TextView lat=(TextView) findViewById(R.id.lat);
        TextView lon=(TextView) findViewById(R.id.Street);

        Geocoder g=new Geocoder(this);
        try {
            Address[] addr= g.getFromLocationName(name.getText().toString(), 1).toArray(new Address[0]);
            lat.setText(String.valueOf(addr[0].getLatitude()));
            lon.setText(String.valueOf(addr[0].getLongitude()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        Geocoder g=new Geocoder(this);
        TextView lat=(TextView) findViewById(R.id.lat);
        TextView lon=(TextView) findViewById(R.id.Street);
        TextView place=(TextView) findViewById(R.id.Street);
        try {
            Address[] addr= g.getFromLocation(location.getLatitude(), location.getLongitude(), 1).toArray(new Address[0]);
            place.setText(addr[0].getLocality());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}