package com.idea.fuel1.ui.home;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

//import in.saicomnetwork.tsmart.Geocoder2;
import com.idea.fuel1.GoogleMap1;
import com.idea.fuel1.R;




public class HomeFragment extends Fragment{
    TextView textView11;
    TextView textView22;
    Button bh1;
    String ss1;
    public static String ss9;


    int currentpage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;
    int NUM_PAGES = 5;
    TextView text1;
    Location currentLocation;
    String fullAdd = null;
    //Context ctx = getContext ( );
   // FusedLocationProviderClient fusedLocationProviderClient;
    SharedPreferences sharedPreferences1;

    private static final int REQUEST_CODE = 101;


    // private HomeViewModel homeViewModel;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        //setHasOptionsMenu (true);





    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  homeViewModel = ViewModelProviders.of (this).get (HomeViewModel.class)
        Menu m1;
        View root = inflater.inflate (R.layout.fragment_home, container, false);




        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient (getContext ());
       // fetchLocation ( );


        final ViewPager mViewPager = root.findViewById (R.id.viewPage);
        textView11 = root.findViewById (R.id.ttt1);
        textView22 = root.findViewById (R.id.ttt2);
        bh1=root.findViewById (R.id.push_button);
        bh1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent ii1=new Intent (getContext (), GoogleMap1.class);
                startActivity (ii1);
            }
        });
        sharedPreferences1=getContext ().getSharedPreferences ("mykey",0);
        String ss10=sharedPreferences1.getString ("value1",null);








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

        ImageAdapter adapterView = new ImageAdapter (getContext ( ));
        mViewPager.setAdapter (adapterView);
        mViewPager.setOnTouchListener (new View.OnTouchListener ( ) {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction ( ) == MotionEvent.ACTION_UP) {
                    mViewPager.setCurrentItem (currentpage, false);
                    return true;

                }
                return false;
            }
        });
        final Handler handler = new Handler ( );
        final Runnable Update = new Runnable ( ) {
            @Override
            public void run() {
                if (currentpage == NUM_PAGES - 1) {
                    currentpage = 0;

                }
                mViewPager.setCurrentItem (currentpage++, true);
            }
        };
        timer = new Timer ( );
        timer.schedule (new TimerTask ( ) {
            @Override
            public void run() {
                handler.post (Update);
            }
        }, DELAY_MS, PERIOD_MS);







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

   /* private void fetchLocation() {

        if (ActivityCompat.checkSelfPermission (getContext (), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (getContext (), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions ((Activity) getContext (), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task <Location> task = fusedLocationProviderClient.getLastLocation ( );
        task.addOnSuccessListener (new OnSuccessListener <Location> ( ) {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    //ss1=getAddress (getContext (),currentLocation.getLatitude (),currentLocation.getLongitude ());
                    if(sharedPreferences1.contains ("value1"))
                    {
                        textView22.setText (sharedPreferences1.getString ("value1",""));

                    }
                    else {


                        textView22.setText (getAddress (getContext ( ), currentLocation.getLatitude ( ), currentLocation.getLongitude ( )));

                        Toast.makeText (getContext ( ), currentLocation.getLatitude ( ) + "" + currentLocation.getLongitude ( ), Toast.LENGTH_SHORT).show ( );
                    }
                    //SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    //assert supportMapFragment != null;
                    //supportMapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
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



   /* public String getAddress(Context context,double lat, double lng) {

        try {
            Geocoder geocoder = new Geocoder (context, Locale.getDefault ( ));
            List <android.location.Address> addresses = geocoder.getFromLocation (lat, lng, 1);
            if (addresses.size ( ) > 0) {
                Address address = addresses.get (0);
                fullAdd = address.getAddressLine (0);
                // ew.setText (fullAdd);

                // if you want only city or pin code use following code //
                String Location = address.getLocality ( );
                String zip = address.getPostalCode ( );
                String Country = address.getCountryName ( );
            }}



        catch(IOException ex){
            ex.printStackTrace ( );
        }
        return fullAdd;



    }*/
}

