package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Option extends AppCompatActivity {
    Button badmin,bcustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_option);
        badmin= findViewById (R.id.admin1);
        bcustomer= findViewById (R.id.customer1);
        bcustomer.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent ic1=new Intent (Option.this,SignUp.class);
                startActivity (ic1);

            }
        });
        badmin.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent ica1=new Intent (Option.this,services.class);
                startActivity (ica1);
            }
        });
    }
}
