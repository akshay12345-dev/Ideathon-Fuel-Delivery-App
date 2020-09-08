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


public class SignUpNext extends AppCompatActivity {
    EditText es6,es7,es9,es10;
    Button bss1;
    TextView ts1;
    String sss1,sss2,sss3,sss4,sss5,sss6,sss7,sss8,sss9;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_up_next);
        es6= findViewById (R.id.et6);
        es7= findViewById (R.id.et7);
        es9= findViewById (R.id.et9);
        es10= findViewById (R.id.et10);
        bss1= findViewById (R.id.reg);
        ts1= findViewById (R.id.ll1);
        sss1=getIntent ().getStringExtra ("eee1");
        sss2=getIntent ().getStringExtra ("eee2");
        sss3=getIntent ().getStringExtra ("eee3");
        sss4=getIntent ().getStringExtra ("eee4");
        sss5=getIntent ().getStringExtra ("eee5");
        ts1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent iii1=new Intent (SignUpNext.this,LogIn.class);
                startActivity (iii1);

            }
        });

        bss1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                add();

            }
        });


    }
    public void add(){
        sss6=es6.getText ().toString ();
        sss7=es7.getText ().toString ();
        sss8=es9.getText ().toString ();
        sss9=es10.getText ().toString ();
        String id=db.push ().getKey ();
        First f1=new First (id,sss1,sss2,sss3,sss4,sss5,sss6,sss7,sss8,sss9);
        if(!TextUtils.isEmpty(sss1)&&!TextUtils.isEmpty(sss2)&&!TextUtils.isEmpty (sss3)&&!TextUtils.isEmpty (sss4)&&!TextUtils.isEmpty (sss5)&&!TextUtils.isEmpty (sss6)&&!TextUtils.isEmpty (sss7)&&!TextUtils.isEmpty (sss8)&&!TextUtils.isEmpty (sss9)){

            //Second e=new Second(id,firstName,lastName,timePick,datePick);
            db.child("customers").child(id).setValue(f1);
            Toast.makeText(SignUpNext.this, "Registered successfully", Toast.LENGTH_SHORT).show();
            Intent icc1=new Intent (SignUpNext.this,Service2.class);
            startActivity (icc1);
        }
        else{
            Toast.makeText(SignUpNext.this, "fill the empty fields", Toast.LENGTH_SHORT).show();
        }

    }


}
