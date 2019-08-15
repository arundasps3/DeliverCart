package com.arundas.delivercart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.arundas.delivercart.R;

public class SplashScreen extends AppCompatActivity {
     Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

          handler =new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {

                 Intent i = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(i);
                 finish();

             }
         },3000);




    }
}
