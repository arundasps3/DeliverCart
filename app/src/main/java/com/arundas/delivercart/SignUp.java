package com.arundas.delivercart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arundas.delivercart.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText Email,Password,Confirmpassword;
    Button signup,signin;
    ProgressDialog progressdialog;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Email =findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Confirmpassword = findViewById(R.id.confirmpassword);
        signup = findViewById(R.id.signupbutton);
        signin=findViewById(R.id.signin2);
        progressdialog =new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Emailentred  = Email.getText().toString();
                String Passwordentred = Password.getText().toString();
                String ConfirmPasswordEntered = Confirmpassword.getText().toString();



                if (TextUtils.isEmpty(Emailentred)) {
                    Toast.makeText(SignUp.this, "please enter Email", Toast.LENGTH_LONG).show();
                    return;
                }


                if (TextUtils.isEmpty(Passwordentred)) {
                    Toast.makeText(SignUp.this, "please enter Password", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(ConfirmPasswordEntered)) {
                    Toast.makeText(SignUp.this, "please enter Re-enter Password", Toast.LENGTH_LONG).show();
                    return;
                }


                if (!Passwordentred.equals(ConfirmPasswordEntered)) {
                    Toast.makeText(SignUp.this, "password doesnt match", Toast.LENGTH_LONG).show();
                    return;
                }


                progressdialog.setMessage("Registering Account");
                progressdialog.show();


             mAuth.createUserWithEmailAndPassword(Emailentred,Passwordentred).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {

                     if (task.isSuccessful()) {
                         Toast.makeText(SignUp.this, "Register Success", Toast.LENGTH_SHORT).show();

                     } else

                         {
                         Toast.makeText(SignUp.this, "Register Failure,Please try again", Toast.LENGTH_SHORT).show();
                     }

                     progressdialog.dismiss();

                 }
             });


            }
        });

    }
}
