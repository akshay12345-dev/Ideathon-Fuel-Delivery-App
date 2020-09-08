package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class services extends AppCompatActivity {
    Button bfuel,bmechanics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_services);
        bfuel=(Button)findViewById (R.id.fuel1);
        bmechanics=(Button)findViewById (R.id.mechanic1);
        bfuel.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent ifuel=new Intent (services.this,AdminLogin.class);
                startActivity (ifuel);
            }
        });
        bmechanics.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent imechanic=new Intent (services.this,AdminLogin2.class);
                startActivity (imechanic);
            }
        });

    }
}
