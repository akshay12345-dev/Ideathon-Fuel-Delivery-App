package com.idea.fuel1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class CustomerBook extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spdf1;
    EditText edpf1;
    TextView tfule1,tfuel2;
    Button bd1;
    String[] country = { "Petrol","Diesel"};
    String spinitem;
    SharedPreferences prefs,prefs1;
    String MY_PREFS_NAME = "TestName";
    String MY_PREFS_NAME1= "TestName1";
    SharedPreferences sharedPreferences7777;
    String smm9;
    String tot6,sd1;
    String delivercon1;
    String sd9,sd10;
    String ad2s,ad3s,ad4s;
    String emal,emal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_customer_book);
        tfule1= findViewById (R.id.pend1);
        tfuel2= findViewById (R.id.pending2);
        spdf1= findViewById (R.id.sp1);
        edpf1= findViewById (R.id.eamp);

        bd1= findViewById (R.id.custpr);
        ad2s=getIntent ().getStringExtra ("address");
        emal1=getIntent ().getStringExtra ("email");



        Query q2= FirebaseDatabase.getInstance ().getReference ("zones").orderByChild ("adrs22").equalTo (ad2s);
        q2.addListenerForSingleValueEvent (new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds1:snapshot.getChildren ()){
                    emal=ds1.child("email22").getValue ().toString ();
                    //s7=ds1.child ("password").getValue ().toString ();




                    //   e3.setText (s8);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        SharedPreferences prefs = getApplicationContext ().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final String loadedString = prefs.getString("petroret", null);
        SharedPreferences prefs1 = getApplicationContext ().getSharedPreferences(MY_PREFS_NAME1, MODE_PRIVATE);
        final String loadedString1 = prefs1.getString("dieselret", null);
        sharedPreferences7777=getApplicationContext ().getSharedPreferences ("mykey8",0);
        smm9=sharedPreferences7777.getString ("value8",null);
        String info="Today's Petrol rate is "+loadedString+" Rupees per litre";
        String info1="Admin mail is "+emal1;
        tfule1.setText (info);
        tfuel2.setText (info1);

        spdf1.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdf1.setAdapter (aa);





        bd1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                //retrieve();
                int na222=Integer.parseInt (loadedString);
                sd1=edpf1.getText ().toString ();
                int li=Integer.parseInt (sd1);
                int tot=na222*li;
                tot6=Integer.toString (tot);
               // edpf2.setText (tot6);


                Intent ipdf=new Intent (CustomerBook.this,BookDetails.class);
                ipdf.putExtra ("fuelt",spinitem);
                ipdf.putExtra ("fuelamt",tot6);
                ipdf.putExtra ("quan",sd1);
                ipdf.putExtra ("delname",sd9);
                ipdf.putExtra ("delcontact",delivercon1);
                ipdf.putExtra ("Admail",emal1);

                startActivity (ipdf);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
        spinitem=country[position];
        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView <?> parent) {

    }

}
