package com.idea.fuel1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {
Button bl1,bl2;
EditText uname,pass;
String semail,spass;
String s6,s7;
    FirebaseAuth fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_log_in);
        uname=(EditText)findViewById (R.id.e1);
        pass=(EditText)findViewById (R.id.e2);
        bl1=(Button)findViewById (R.id.b1);
        bl2=(Button)findViewById (R.id.b2);
        semail=uname.getText ().toString ();
        spass=pass.getText ().toString ();

        fb=FirebaseAuth.getInstance();
        FirebaseUser currentUser = fb.getCurrentUser();



        bl1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                //Intent il2=new Intent(LogIn.this,Bottom.class);
                //startActivity (il2);
                validate();
            }
        });
        bl2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent il1=new Intent (LogIn.this,SignUp.class);
                startActivity (il1);
            }
        });
    }
    public void validate()
    {
        String email=uname.getText().toString();
        String password=pass.getText().toString();
        Query query= FirebaseDatabase.getInstance ().getReference ("customers").orderByChild ("email").equalTo (email);
        query.addListenerForSingleValueEvent (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds1:snapshot.getChildren ()){
                    s6=ds1.child("email").getValue ().toString ();
                    s7=ds1.child ("password").getValue ().toString ();




                    //   e3.setText (s8);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(email.equals (s6)&&password.equals (s7))
        {
            Intent iii3=new Intent (LogIn.this,Bottom.class);
            startActivity (iii3);
        }
        else if(!email.equals (s6)&&!password.equals (s7)){
            Toast.makeText (LogIn.this,"Email and Password do not match",Toast.LENGTH_SHORT).show ();
        }
        else
        {
            Toast.makeText (LogIn.this,"Error",Toast.LENGTH_SHORT).show ();
        }







    }
}



