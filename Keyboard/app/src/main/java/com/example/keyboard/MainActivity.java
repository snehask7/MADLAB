package com.example.keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String enteredText="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v) {
        Button b = (Button)v;
        enteredText+=b.getText().toString();
        TextView tb=(TextView) findViewById(R.id.tb);
        tb.setText(enteredText);
    }
    public void onClickSpace(View v) {
        enteredText+=" ";
        TextView tb=(TextView) findViewById(R.id.tb);
        tb.setText(enteredText);
    }
    public void onClickBackSpace(View v) {
        enteredText= enteredText.substring(0, enteredText.length() - 1);
        TextView tb=(TextView) findViewById(R.id.tb);
        tb.setText(enteredText);
    }
}