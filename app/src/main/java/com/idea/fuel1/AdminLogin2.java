package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogin2 extends AppCompatActivity {
    EditText eml1,eml2;
    Button bml1,bml2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_login2);
        eml1=(EditText)findViewById (R.id.etl11);
        eml2=(EditText)findViewById (R.id.etl22);
        bml1=(Button)findViewById (R.id.btl11);
        bml2=(Button)findViewById (R.id.btl22);
        bml2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iml2=new Intent(AdminLogin2.this,AdminSignUp2.class);
                startActivity (iml2);
            }
        });

    }
}
