package com.idea.fuel1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {
    EditText eel1,eel2;
    Button bbl1,bbl2;
    String s66,s77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_login);
        eel1=(EditText)findViewById (R.id.etl1);
        eel2=(EditText)findViewById (R.id.etl2);
        bbl1=(Button)findViewById (R.id.btl1);
        bbl2=(Button)findViewById (R.id.btl2);
        bbl1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                validData2();
            }
        });
        bbl2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iis1=new Intent (AdminLogin.this,AdminSignUp.class);
                startActivity (iis1);
            }
        });

    }
    public void validData2()
    {
        String email=eel1.getText().toString();
        String password=eel2.getText().toString();
        SharedPreferences sharedPref=getSharedPreferences ("mykey",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit ();
        editor.putString ("value1",email);
        editor.apply ();
        Query query= FirebaseDatabase.getInstance ().getReference ("admins").orderByChild ("email11").equalTo (email);
        query.addListenerForSingleValueEvent (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds1:snapshot.getChildren ()){
                    s66=ds1.child("email11").getValue ().toString ();
                    s77=ds1.child ("password11").getValue ().toString ();




                    //   e3.setText (s8);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if(email.equals (s66)&&password.equals (s77))
        {
            Intent iii3=new Intent (AdminLogin.this,AdminMap.class);
            startActivity (iii3);

        }
        else if(!email.equals (s66)&&!password.equals (s77)){
            //Toast.makeText (LogIn.this,"Email and Password do not match",Toast.LENGTH_SHORT).show ();
        }
        else
        {
            Toast.makeText (AdminLogin.this,"Error",Toast.LENGTH_SHORT).show ();
        }





    }
}
