package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminSignNext2 extends AppCompatActivity {
    EditText emll5,emll6,emll7,emll8;
    Button btmll1;
    TextView tmll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_sign_next2);
        emll5=(EditText)findViewById (R.id.ets66);
        emll6=(EditText)findViewById (R.id.ets77);
        emll7=(EditText)findViewById (R.id.ets88);
        emll8=(EditText)findViewById (R.id.ets88);
        btmll1=(Button)findViewById (R.id.btsreg1);
        tmll1=(TextView)findViewById (R.id.etsll11);
        tmll1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent ill1=new Intent (AdminSignNext2.this,AdminLogin2.class);
                startActivity (ill1);
            }
        });
        btmll1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent ill2=new Intent (AdminSignNext2.this,AdminLogin2.class);
                startActivity (ill2);
               }
        });
    }
}
