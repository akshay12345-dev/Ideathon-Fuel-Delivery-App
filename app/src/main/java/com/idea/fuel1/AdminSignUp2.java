package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminSignUp2 extends AppCompatActivity {
    EditText emll1,emll2,emll3,emll4;
    Button bmll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_sign_up2);
        emll1=(EditText)findViewById (R.id.ets11);
        emll2=(EditText)findViewById (R.id.ets22);
        emll3=(EditText)findViewById (R.id.ets33);
        emll4=(EditText)findViewById (R.id.ets44);
        bmll1=(Button)findViewById (R.id.btsnext111);
        bmll1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iii22=new Intent (AdminSignUp2.this,AdminSignNext2.class);
                startActivity (iii22);
            }
        });
    }
}
