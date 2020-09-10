package com.idea.fuel1.ui.dashboard;



import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

//import in.saicomnetwork.tsmart.Geocoder2;
import com.idea.fuel1.AdminMap;
import com.idea.fuel1.AdminLogin;
import com.idea.fuel1.AdminSignNext;
import com.idea.fuel1.Four;
import com.idea.fuel1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DashboardFragment extends Fragment{
EditText ed1,ed2,ed3,ed4;
Button bd1;
SharedPreferences sharedPreferences44,sharedPreferences55,sharedPreferences77;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();


    // private HomeViewModel homeViewModel;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        //setHasOptionsMenu (true);





    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  homeViewModel = ViewModelProviders.of (this).get (HomeViewModel.class)
        Menu m1;
        View root = inflater.inflate (R.layout.fragment_dashboard, container, false);
        ed1=root.findViewById (R.id.edd1);
        ed2=root.findViewById (R.id.edd2);
        ed3=root.findViewById (R.id.edd3);
        ed4=root.findViewById (R.id.edd4);
        bd1=root.findViewById (R.id.btnLn);

        sharedPreferences77=getContext ().getSharedPreferences ("mykey8",0);
        String ss14=sharedPreferences77.getString ("value8",null);
        ed1.setText (ss14);
        sharedPreferences44=getContext ().getSharedPreferences ("mykey4",0);
        String ss11=sharedPreferences44.getString ("value4",null);
        ed4.setText (ss11);
        bd1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                String sd1=ed1.getText ().toString ();
                String sd2=ed2.getText ().toString ();
                String sd3=ed3.getText ().toString ();
                String sd4=ed4.getText ().toString ();

                sharedPreferences55=getContext ().getSharedPreferences ("mykey",0);
                String ss12=sharedPreferences55.getString ("value1",null);
                String ss13=db.push ().getKey ();
                Four fr4=new Four(ss13,sd1,sd2,sd3,sd4,ss12);
                db.child("zonerecord").child(ss13).setValue(fr4);
                Toast.makeText(getContext (), "Registered Succeessfully", Toast.LENGTH_SHORT).show();
                Toast.makeText (getContext (),"Detail submitted",Toast.LENGTH_SHORT).show ();






            }
        });

        return root;
    }








    }


