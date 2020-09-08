package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminSignUp extends AppCompatActivity {
    EditText etss1,etss2,etss3,etss4;
    Button btss1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_sign_up);
        etss1= findViewById (R.id.ets1);
        etss2= findViewById (R.id.ets2);
        etss3= findViewById (R.id.ets3);
        etss4= findViewById (R.id.ets4);
        btss1= findViewById (R.id.btsnext11);
        btss1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iiii1=new Intent (AdminSignUp.this,AdminSignNext.class);
                iiii1.putExtra ("name1",etss1.getText ().toString ());
                iiii1.putExtra ("license",etss2.getText ().toString ());
                iiii1.putExtra ("adhaar",etss3.getText ().toString ());
                iiii1.putExtra ("email",etss4.getText ().toString ());

                startActivity (iiii1);

            }
        });
    }
}
