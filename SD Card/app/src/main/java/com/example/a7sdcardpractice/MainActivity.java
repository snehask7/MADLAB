package com.example.a7sdcardpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    File sdcard= Environment.getExternalStorageDirectory();
    EditText filename;
    EditText content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        filename=(EditText) findViewById(R.id.filename);
        content=(EditText) findViewById(R.id.content);
    }
    public void read(View v) throws IOException {
        FileReader f=new FileReader(new File(sdcard,filename.getText().toString()));
        char[] buff=new char[1025];
        f.read(buff);
        content.setText(new String(buff));

    }
    public void write(View v) throws IOException {
        FileWriter f=new FileWriter(new File(sdcard,filename.getText().toString()));
        f.write(content.getText().toString());
        f.close();
        Toast.makeText(this, "Write done", Toast.LENGTH_SHORT).show();
    }

}