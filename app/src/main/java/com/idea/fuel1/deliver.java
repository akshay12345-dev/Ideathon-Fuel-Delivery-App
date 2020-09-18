package com.idea.fuel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class deliver extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button bd1;
    String sddr;
    Double dellat,dellong;
    String fullAdd1;
    DatabaseReference db;
    SharedPreferences sharedPreferences1011;
    FusedLocationProviderClient fusedLocationProviderClient;
    SharedPreferences sharedPreferences44,sharedPreferences55,sharedPreferences77,sharedPreferences1012,sharedPreferences1013,sharedPreferences1014;
    private static final int REQUEST_CODE = 101;
    Location currentLocation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_deliver);
        ed1= findViewById (R.id.edd1);
        ed2= findViewById (R.id.edd2);
        ed3= findViewById (R.id.edd3);
        ed4= findViewById (R.id.edd4);
        bd1= findViewById (R.id.btnLn);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient (getApplicationContext ());
        fetchLocation ( );


        db= FirebaseDatabase.getInstance().getReference();
        sharedPreferences77=getApplicationContext ().getSharedPreferences ("mykey8",0);
        String ss14=sharedPreferences77.getString ("value8",null);
        ed1.setText (ss14);
        sharedPreferences44=getApplicationContext ().getSharedPreferences ("mykey4",0);
        String ss11=sharedPreferences44.getString ("value4",null);
        ed4.setText (ss11);
        bd1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                String sd1=ed1.getText ().toString ();
                String sd2=ed2.getText ().toString ();
                String sd3=ed3.getText ().toString ();
                String sd4=ed4.getText ().toString ();
                String dellat1=Double.toString (dellat);
                String dellong1=Double.toString (dellong);
                sharedPreferences1011=getSharedPreferences ("delName",MODE_PRIVATE);
                SharedPreferences.Editor edtx11=sharedPreferences1011.edit ();
                edtx11.putString ("v1",sd2);
                edtx11.apply ();
                sharedPreferences1012=getSharedPreferences ("delContact",MODE_PRIVATE);
                SharedPreferences.Editor edtx12=sharedPreferences1012.edit ();
                edtx12.putString ("v2",sd3);
                edtx12.apply ();
                sharedPreferences1013=getSharedPreferences ("dellatu",MODE_PRIVATE);
                SharedPreferences.Editor edtx13=sharedPreferences1011.edit ();
                edtx13.putString ("v3",dellat1);
                edtx13.apply ();
                sharedPreferences1014=getSharedPreferences ("dellongu",MODE_PRIVATE);
                SharedPreferences.Editor edtx14=sharedPreferences1011.edit ();
                edtx14.putString ("v4",dellong1);
                edtx14.apply ();

                sharedPreferences55=getApplicationContext ().getSharedPreferences ("mykey",0);
                String ss12=sharedPreferences55.getString ("value1",null);
                String ss13=db.push ().getKey ();
                Four fr4=new Four(ss13,sd1,sd2,sd3,sd4,ss12,dellat1,dellong1);
                db.child("zonerecord").child(ss13).setValue(fr4);
                Toast.makeText(getApplicationContext (), "Registered Succeessfully", Toast.LENGTH_SHORT).show();
                Toast.makeText (getApplicationContext (),"Detail submitted",Toast.LENGTH_SHORT).show ();






            }
        });

    }
    private void fetchLocation() {

        if (ActivityCompat.checkSelfPermission (getApplicationContext (), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (getApplicationContext (), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions ((Activity) getApplicationContext (), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task <Location> task = fusedLocationProviderClient.getLastLocation ( );
        task.addOnSuccessListener (new OnSuccessListener <Location> ( ) {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation1 = location;
                    //ss1=getAddress (getContext (),currentLocation.getLatitude (),currentLocation.getLongitude ());
                   /* if(sharedPreferences1.contains ("value1"))
                    {
                        textView22.setText (sharedPreferences1.getString ("value1",""));

                    }*/
                    // else {

                    sddr=getAddress(getApplicationContext (),currentLocation1.getLatitude (),currentLocation1.getLatitude ());
                   //textView22.setText (getAddress (getContext ( ), currentLocation.getLatitude ( ), currentLocation.getLongitude ( )));
                    dellat=currentLocation1.getLatitude ();
                    dellong=currentLocation1.getLongitude ();
                    //Toast.makeText (getContext ( ), currentLocation.getLatitude ( ) + "" + currentLocation.getLongitude ( ), Toast.LENGTH_SHORT).show ( );
                    //}
                    //SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    //assert supportMapFragment != null;
                    //supportMapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
    }
    public String getAddress(Context context, double lat, double lng) {

        try {
            Geocoder geocoder = new Geocoder (context, Locale.getDefault ( ));
            List <Address> addresses = geocoder.getFromLocation (lat, lng, 1);
            if (addresses.size ( ) > 0) {
                Address address = addresses.get (0);
                fullAdd1 = address.getAddressLine (0);
                // ew.setText (fullAdd);

                // if you want only city or pin code use following code //
                String Location = address.getLocality ( );
                String zip = address.getPostalCode ( );
                String Country = address.getCountryName ( );
            }}



        catch(IOException ex){
            ex.printStackTrace ( );
        }
        return fullAdd1;



    }

}
