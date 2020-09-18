package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    EditText emsw1,emsw2,emsw3;
    Button bnmt,bnmt1;
    SharedPreferences sdd;
    String str6;
    String bvm1,bvm2,bvm3,bvm4,bvm5,bvm6;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_payment);
        emsw1= findViewById (R.id.nmk3);
        emsw2= findViewById (R.id.nmk2);
        emsw3= findViewById (R.id.nmk1);
        bnmt= findViewById (R.id.big);
        bnmt1= findViewById (R.id.big1);
        bvm1=getIntent ().getStringExtra ("emrt");
        bvm2=getIntent ().getStringExtra ("qty");
        bvm3=getIntent ().getStringExtra ("amsd");
        bvm4=getIntent ().getStringExtra ("pyu");
        bvm5=getIntent ().getStringExtra ("vd");
        bvm6=getIntent ().getStringExtra ("edumail");


        sdd=getApplicationContext ().getSharedPreferences ("mykey",0);
        str6=sdd.getString ("value1",null);
        bnmt.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText (getApplicationContext (),"Your order sent successfully and amount can be debited after successfull deliver",Toast.LENGTH_SHORT ).show ();
            }
        });
        bnmt1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                dtfd();


            }
        });
    }
    public void dtfd()
    {
        String idorder=db.push ().getKey ();
        Fifth ff5=new Fifth(idorder,bvm1,bvm2,bvm3,bvm4,bvm5,bvm6);
        db.child ("transaction").child (idorder).setValue (ff5);
        Toast.makeText (getApplicationContext (),"Amount "+bvm3+" debited from your account successfully Details saved successfully and ",Toast.LENGTH_SHORT).show ();

    }
}
