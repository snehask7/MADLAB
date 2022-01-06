package com.example.a2calcpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {
    boolean opentered=false;
    String num1="",num2="",op="";
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(TextView) findViewById(R.id.result);
    }
    public void onClickNum(View v){
       Button b=(Button)v;
        if(opentered==false)
            num1+=b.getText().toString();
        else
            num2+=b.getText().toString();
        display.setText(num1+op+num2);

    }
    public void onClickOp(View v){
        if(opentered==false)
        {
            Button b=(Button) v;
            op=b.getText().toString();
            opentered=true;
            display.setText(num1+op+num2);
        }
    }
    public void onClickEval(View v) throws ScriptException {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        Double result= (Double) engine.eval(display.getText().toString());
        display.setText(result.toString());
//        boolean dec;
//        if(num1.contains(".")){
//           dec=true;
//        }
//        else if(num2.contains(".")){
//            dec=true;
//        }
//        else{
//            dec=false;
//        }
//        Log.d("result",op+dec+op.length());
//
//        if(op.equalsIgnoreCase("+")){
//            if(dec==false) {
//                Integer result;
//                result = Integer.parseInt(num1) + Integer.parseInt(num2);
//                display.setText(result.toString());
//            }
//            else{
//                Float result;
//                result = Float.parseFloat(num1) + Float.parseFloat(num2);
//                display.setText(result.toString());
//            }
//        }

    }
}