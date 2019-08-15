package com.arundas.delivercart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arundas.delivercart.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText Email,Password;
    Button Signin,Signup;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Email =findViewById(R.id.email);
        Password =findViewById(R.id.password);

        Signin=findViewById(R.id.signin);
        Signup=findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);


            }
        });


        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String EmailEntered  = Email.getText().toString();
                String PasswordEntered =Password.getText().toString();


              mAuth.signInWithEmailAndPassword(EmailEntered,PasswordEntered).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {

                      if (task.isSuccessful())
                      {

                          Toast.makeText(MainActivity.this,"Login is Successful",Toast.LENGTH_LONG).show();
                          Intent i= new Intent(getApplicationContext(),Home.class);
                          startActivity(i);

                      }

                      else
                      {

                          Toast.makeText(MainActivity.this,"Login Failure ",Toast.LENGTH_LONG).show();
                      }


                  }
              });


            }
        });

    }
}
