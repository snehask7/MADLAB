package com.example.outputprimitives;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));

        Canvas canvas = new Canvas(bg);
         Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(90);
        canvas.drawRect(400, 200, 650, 700, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(200, 950, 150, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(520, 850, 520, 1150, paint);
        paint.setColor(Color.CYAN);
         RectF rectF = new RectF(50, 20, 400, 500);
        canvas.drawArc (rectF, 90, 65, false, paint);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Car.class));
            }
        });
    }
}