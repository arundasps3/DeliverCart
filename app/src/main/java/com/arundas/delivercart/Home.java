package com.arundas.delivercart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arundas.delivercart.R;

public class Home extends AppCompatActivity {


    Button walmart,loblaws,zehrs,canadiantire;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

     walmart= findViewById(R.id.wal);
     loblaws=findViewById(R.id.lob);
     zehrs=findViewById(R.id.zehrs);
     canadiantire=findViewById(R.id.can);





     walmart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


             Intent i =new Intent(getApplicationContext(),Walmart.class);
             startActivity(i);


         }
     });


     loblaws.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i =new Intent(getApplicationContext(),Loblaws.class);
             startActivity(i);

         }
     });

     zehrs.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i =new Intent(getApplicationContext(),Zehrs.class);
             startActivity(i);

         }
     });

     canadiantire.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i =new Intent(getApplicationContext(),CanadianTire.class);
             startActivity(i);

         }
     });


    }
}
