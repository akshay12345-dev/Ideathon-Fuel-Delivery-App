package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.InterruptedByTimeoutException;

public class Service2 extends AppCompatActivity {
    Button bms1,bms2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_service2);
        bms1=(Button)findViewById (R.id.fuel11);
        bms2=(Button)findViewById (R.id.mechanic11);
        bms1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent ims1=new Intent (Service2.this,LogIn.class);
                startActivity (ims1);
            }
        });
    }
}
