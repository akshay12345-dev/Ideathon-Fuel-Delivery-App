package com.idea.fuel1.ui.logout;


import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.idea.fuel1.Option;
import com.idea.fuel1.R;

public class fragment_logout extends Fragment{

    Button bdfc1;
    String ss1;




    //Context ctx = getContext ( );


    // private HomeViewModel homeViewModel;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        //setHasOptionsMenu (true);





    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  homeViewModel = ViewModelProviders.of (this).get (HomeViewModel.class)
        Menu m1;
        View root = inflater.inflate (R.layout.fragment_logout, container, false);
        bdfc1=root.findViewById (R.id.btnLnnt11);






        bdfc1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent ii1=new Intent (getContext (),Option.class);
                startActivity (ii1);
                Toast.makeText (getContext (),"Successfully logout",Toast.LENGTH_LONG).show ();
            }
        });
        //sharedPreferences1=getContext ().getSharedPreferences ("mykey",0);
        //String ss10=sharedPreferences1.getString ("value1",null);








        //textView22.setText (ss10);//Location setcha code

        // Log.d("Debug",Geocoder2.getValue ());
       /* ss9=(Geocoder2.getValue ());
        if(ss9.length ()>2)
        {
            textView22.setText (ss9);
        }
        else
        {
            textView22.setText (ss1);
        }*/
      /*textView22.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                textView22.setText (Geocoder2.getValue ());

            }
        });*/







       /* textView11.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent ii3 = new Intent (getContext (), Geocoder2.class);
                startActivity (ii3);
            }
        });*/








       /* homeViewModel.getText ( ).observe (getViewLifecycleOwner ( ), new Observer <String> ( ) {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText (s);
            }
        });*/

        return root;
    }
   /* public void onCreateOptionsMenu(Menu menu, MenuInflater m1) {
        //return super.onCreateOptionsMenu(menu);

        ///Inflate the menu; this adds items to the action bar if it is present.
        m1.inflate(R.menu.my_account_settings, menu);


    }*/



    /*@Override
   public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng (currentLocation.getLatitude ( ), currentLocation.getLongitude ( ));
        //MarkerOptions markerOptions = new MarkerOptions ( ).position (latLng).title (getAddress (getContext (),latLng.latitude, latLng.longitude));
        //LatLng latLng = new LatLng (currentLocation.getLatitude ( ), currentLocation.getLongitude ( ));

        //googleMap.animateCamera (CameraUpdateFactory.newLatLng (latLng));
        //googleMap.animateCamera (CameraUpdateFactory.newLatLngZoom (latLng, 5));
        //googleMap.addMarker (markerOptions);


    }*/



   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation ( );
                }
                break;
        }
    }*/




}

