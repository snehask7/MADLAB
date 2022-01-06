package com.example.a5multithreadingpractice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView box;
    private TextView coord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            public void run() {
                box=(TextView) findViewById(R.id.box);
                coord=(TextView) findViewById(R.id.coord);
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int[] location=new int[2];
                            box.getLocationOnScreen(location);
                            String display="Location: (" + location[0] + ", " + location[1] + ")";
                            coord.setText(display);
                            box.animate().translationXBy(20);
                            coord.animate().translationXBy(20);
                        }
                    });
                }
            }
        }).start();
    }
    public void onClickDialog(View v) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Progress Dialog");
        pd.setMessage("Sleeping");
        pd.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.hide();
            }
        }, 2000);
    }

    public void onClickProgressBar(View v){
        ProgressBar pb=(ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                int i;
                for(i=0;i<=100;i+=10){
                    pb.setProgress(i);
                    pb.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pb.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
        }).start();
    }
}