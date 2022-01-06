package com.example.outputprimitives;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Car extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        Button bt_paint=findViewById(R.id.bt_paint);
        Button bt_zoom=findViewById(R.id.bt_zoom);
        Button bt_rotate=findViewById(R.id.bt_rotate);
        Button bt_forward=findViewById(R.id.bt_forward);
        Button bt_backward=findViewById(R.id.bt_backward);
        ImageView iv_animate=findViewById(R.id.iv_animate);

        bt_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate));
            }
        });
        bt_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom));
            }
        });

        bt_paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b=Bitmap.createBitmap(720,1280, Bitmap.Config.ARGB_8888);
                iv_animate.setBackgroundDrawable(new BitmapDrawable(b));
                Canvas canvas=new Canvas(b);
                Paint p=new Paint();
                p.setStrokeWidth(10);
                p.setColor(Color.RED);
                RectF r=new RectF(200,100,600,400);
                canvas.drawRect(r,p);
                p.setColor(Color.BLACK);
                canvas.drawCircle(300, 450, 45, p);
                canvas.drawCircle(520, 450, 45, p);
            }
        });
        bt_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(300f).setDuration(600);
            }
        });
        bt_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_animate.animate().translationXBy(-300f).setDuration(600);
            }
        });
    }
}