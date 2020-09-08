package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AdminSignNext extends AppCompatActivity {
    EditText etsn1,etsn2,etsn3,etsn4;
    Button btsn1;
    TextView tsn1;
    String ssss1,ssss2,ssss3,ssss4,ssss5,ssss6,ssss7,ssss8;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_sign_next);
        etsn1= findViewById (R.id.ets6);
        etsn2= findViewById (R.id.ets7);
        etsn3= findViewById (R.id.ets8);
        etsn4= findViewById (R.id.ets9);
        btsn1= findViewById (R.id.btsreg);
        tsn1= findViewById (R.id.etsll1);
        ssss1=getIntent ().getStringExtra ("name1");
        ssss2=getIntent ().getStringExtra ("license");
        ssss3=getIntent ().getStringExtra ("adhaar");
        ssss4=getIntent ().getStringExtra ("email");
        tsn1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iiin1=new Intent (AdminSignNext.this,AdminLogin.class);
                startActivity (iiin1);
            }
        });
        btsn1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                addData1();

               /* ssss5=etsn1.getText ().toString ();
                ssss6=etsn2.getText ().toString ();
                ssss7=etsn3.getText ().toString ();
                ssss8=etsn4.getText ().toString ();
                String id1=db.push ().getKey ();
                Second f11=new Second(id1,ssss1,ssss2,ssss3,ssss4,ssss5,ssss6,ssss7,ssss8);
                if(!TextUtils.isEmpty(ssss1)&&!TextUtils.isEmpty(ssss2)&&!TextUtils.isEmpty (ssss3)&&!TextUtils.isEmpty (ssss4)&&!TextUtils.isEmpty (ssss5)&&!TextUtils.isEmpty (ssss6)&&!TextUtils.isEmpty (ssss7)&&!TextUtils.isEmpty (ssss8)){

                    //Second e=new Second(id,firstName,lastName,timePick,datePick);
                    db.child("admins").child(id1).setValue(f11);
                    Toast.makeText(AdminSignNext.this, "Registered Succeessfully", Toast.LENGTH_SHORT).show();
                    Intent iccc1=new Intent (AdminSignNext.this,AdminLogin.class);
                    startActivity (iccc1);
                }
                else{
                    Toast.makeText(AdminSignNext.this, "fill the empty fields", Toast.LENGTH_SHORT).show();
                }*/

            }
        });

    }
    public void  addData1()
    {
        ssss5=etsn1.getText ().toString ();
        ssss6=etsn2.getText ().toString ();
        ssss7=etsn3.getText ().toString ();
        ssss8=etsn4.getText ().toString ();
        String id1=db.push ().getKey ();
        Second f11=new Second(id1,ssss1,ssss2,ssss3,ssss4,ssss5,ssss6,ssss7,ssss8);
        if(!TextUtils.isEmpty(ssss1)&&!TextUtils.isEmpty(ssss2)&&!TextUtils.isEmpty (ssss3)&&!TextUtils.isEmpty (ssss4)&&!TextUtils.isEmpty (ssss5)&&!TextUtils.isEmpty (ssss6)&&!TextUtils.isEmpty (ssss7)&&!TextUtils.isEmpty (ssss8)){

            //Second e=new Second(id,firstName,lastName,timePick,datePick);
            db.child("admins").child(id1).setValue(f11);
            Toast.makeText(AdminSignNext.this, "Registered Succeessfully", Toast.LENGTH_SHORT).show();
            Intent iccc1=new Intent (AdminSignNext.this,AdminLogin.class);
            startActivity (iccc1);
        }
        else{
            Toast.makeText(AdminSignNext.this, "fill the empty fields", Toast.LENGTH_SHORT).show();
        }

    }
}
