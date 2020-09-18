package com.idea.fuel1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class BookDetails extends AppCompatActivity {
    TextView ty1,ty2,ty3,ty4,ty5,ty6,ty7,ty10,ty11,ty12;
   TextView ty8,ty9;
    String sm1,sm2,sm3,sm4,sm5,sm6,sm10,sm11,sm77;
    //String MY_PREFS_NAME22,MY_PREFS_NAME33;
    Button btx,btx1;
    DatabaseReference db1= FirebaseDatabase.getInstance().getReference();
    SharedPreferences sharedPreferencescname,sharedPreferences1011,sharedPreferencesvehcd,sharedPreferences777,sharedPreferencesp91;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_book_details);
        ty1= (TextView)findViewById (R.id.lk12);
        ty2= (TextView)findViewById (R.id.lk13);
        ty3= (TextView)findViewById (R.id.lk14);
        ty4= (TextView)findViewById (R.id.lk15);
        ty5= (TextView)findViewById (R.id.lk16);
        ty6=(TextView) findViewById (R.id.lk17);
        ty7=(TextView) findViewById (R.id.lk18);
        ty8=(TextView) findViewById (R.id.lk19);
        ty9=(TextView)findViewById (R.id.lk20);
        ty10=(TextView)findViewById (R.id.lk21);
        ty11=(TextView)findViewById (R.id.lk22);
        ty12=(TextView)findViewById (R.id.lk55);
        btx= findViewById (R.id.bbbook);
        btx1= findViewById (R.id.bbbook1);
        sm3=getIntent ().getStringExtra ("fuelt");
        sm5=getIntent ().getStringExtra ("fuelamt");
        sm4=getIntent ().getStringExtra ("quan");
        sm11=getIntent ().getStringExtra ("Admail");
        sharedPreferences1011=getApplicationContext ().getSharedPreferences ("custloc",0);
        sm6=sharedPreferences1011.getString ("cusmd4",null);
        sharedPreferencesvehcd=getApplicationContext ().getSharedPreferences ("custvehic",0);
        sm2=sharedPreferencesvehcd.getString ("customervehicle",null);
        sharedPreferencescname=getApplicationContext ().getSharedPreferences ("custemailll2",0);
        sm1=sharedPreferencescname.getString ("value1",null);


        //sharedPreferencesp91=getApplicationContext ().getSharedPreferences ("adcon",0);
        //sm10=sharedPreferencesp91.getString ("admincon",null);

        ty1.setText ("Customer email is "+sm1);
        ty2.setText ("customer Vehicle number is "+sm2);
        ty3.setText ("Fuel Type is "+sm3);
        ty4.setText ("Fuel quantity is "+sm4+" litre");
        ty5.setText ("Total Amount is "+sm5+" Rupees");
        ty6.setText ("Customer Address is "+sm6);


        ty11.setText ("Admin Mail is "+sm11);
        ty12.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {

                Query q9= FirebaseDatabase.getInstance ().getReference ("zonerecord").orderByChild ("email4").equalTo (sm11);
                q9.addListenerForSingleValueEvent (new ValueEventListener ( ) {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds1:snapshot.getChildren ()){
                          String sm7=ds1.child("ppname").getValue ().toString ();
                           String sm8=ds1.child ("dbname").getValue ().toString ();
                            String sm9=ds1.child ("dcontact").getValue ().toString ();
                            ty7.setText ("Petrol Pump Name is "+sm7);
                            ty8.setText ("Delivery boy Name is "+sm8);
                            ty9.setText ("Delivery boy contact number is "+sm9);
                            sm77=sm7;




                            //   e3.setText (s8);
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                    addcon();

            }
        });
        btx.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent iyu=new Intent (BookDetails.this,Payment.class);
                iyu.putExtra ("emrt",sm1);
                iyu.putExtra ("qty",sm4);
                iyu.putExtra ("amsd",sm5);
               // iyu.putExtra ("pyu",sm7);
                iyu.putExtra ("vd",sm2);
                iyu.putExtra ("edumail",sm11);
                startActivity (iyu);
            }
        });
        btx1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                String sad1="Customer mail "+sm1+" Vehicle- "+sm2+" Quantity "+sm4+" litre and amount is "+sm5+" Address of customer is "+sm6;
                Intent isend=new Intent (Intent.ACTION_VIEW,Uri.parse ("sms:"+sm10));
                isend.putExtra ("sms_body",sad1);
                startActivity (isend);

            }
        });




    }
        public void addcon() {
            Query q10 = FirebaseDatabase.getInstance ( ).getReference ("admins").orderByChild ("email11").equalTo (sm11);
            q10.addListenerForSingleValueEvent (new ValueEventListener ( ) {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot ds1 : snapshot.getChildren ( )) {
                      sm10=ds1.child ("contact11").getValue ().toString ();
                        ty10.setText ("Admin Contact no is "+sm10);

                        //   e3.setText (s8);
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
        }
}
