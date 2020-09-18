package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    Button bs1;
    EditText es1,es2,es3,es4;
    EditText ess5;
    SharedPreferences sstp55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_up);
        bs1= findViewById (R.id.next);
        es1= findViewById (R.id.et1);
        es2= findViewById (R.id.et2);
        es3= findViewById (R.id.et3);
        es4= findViewById (R.id.et4);
        ess5= findViewById (R.id.et5);

        bs1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String sg99=es3.getText ().toString ();
                sstp55=getSharedPreferences ("custvehic",MODE_PRIVATE);
                SharedPreferences.Editor ecmk1=sstp55.edit ();
                ecmk1.putString ("customervehicle",sg99);
                ecmk1.apply ();
                Intent is1=new Intent (SignUp.this,SignUpNext.class);
                is1.putExtra ("eee1",es1.getText ().toString ());
                is1.putExtra ("eee2",es2.getText ().toString ());
                is1.putExtra ("eee3",es3.getText ().toString ());
                is1.putExtra ("eee4",es4.getText ().toString ());
                is1.putExtra ("eee5",ess5.getText ().toString ());
                startActivity (is1);
            }
        });
    }
}
