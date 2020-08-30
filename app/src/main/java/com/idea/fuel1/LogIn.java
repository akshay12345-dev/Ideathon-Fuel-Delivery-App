package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {
Button bl1,bl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_log_in);
        bl1=(Button)findViewById (R.id.b1);
        bl2=(Button)findViewById (R.id.b2);
        bl1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent il2=new Intent(LogIn.this,Bottom.class);
                startActivity (il2);
            }
        });
        bl2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent il1=new Intent (LogIn.this,SignUp.class);
                startActivity (il1);
            }
        });
    }
}
