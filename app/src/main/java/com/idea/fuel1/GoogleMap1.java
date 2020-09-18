package com.idea.fuel1;

import java.io.IOException;
import java.util.List;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.idea.fuel1.ui.home.HomeFragment;

public class GoogleMap1 extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,GoogleMap.OnInfoWindowClickListener {
    //public static final String ROOT_URL = "http://192.168.43.61:8082/Example1";
    GoogleMap mMap;
    MarkerOptions markerOptions;
    LatLng latLng;

    String addrs;
    String longi;
    String lati;
    //String addressText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map1);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync (this);
        // googleMap=supportMapFragment.getMap();


        // Getting a reference to the map
        //googleMap = supportMapFragment.getMap();

        // Getting reference to btn_find of the layout activity_main
        Button btn_find = findViewById(R.id.btn_find);
        Button bcurrent= findViewById (R.id.bb1);
        bcurrent.setOnClickListener (new View.OnClickListener (){
            public void onClick(View v)
            {
                Intent ii11=new Intent (getApplicationContext (),GoogleMap2.class);
                startActivity (ii11);
            }
        });







        // Defining button click event listener for the find button
        OnClickListener findClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting reference to EditText to get the user input location
                EditText etLocation = findViewById(R.id.et_location);

                // Getting user input location
                String location = etLocation.getText().toString();

                if(location!=null && !location.equals("")){
                    new GeocoderTask().execute(location);
                }
            }
        };

        // Setting button click event listener for the find button
        btn_find.setOnClickListener(findClickListener);

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.activity_google_map1, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        mMap.setOnMarkerClickListener (this);

    }

    private void buildGoogleApiClient() {
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //LocationtUser ();


        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {


    }


    // An AsyncTask class for accessing the GeoCoding Web Service
    public class GeocoderTask extends AsyncTask<String, Void, List<Address>>{

        @Override
        protected List<Address> doInBackground(String... locationName) {
            // Creating an instance of Geocoder class
            Geocoder geocoder = new Geocoder(getBaseContext());
            List<Address> addresses = null;

            try {
                // Getting a maximum of 3 Address that matches the input text
                addresses = geocoder.getFromLocationName(locationName[0], 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return addresses;
        }

        @Override
        protected void onPostExecute(List<Address> addresses) {

            if(addresses==null || addresses.size()==0){
                Toast.makeText(getBaseContext(), "No Location found", Toast.LENGTH_SHORT).show();
            }

            // Clears all the existing markers on the map
            mMap.clear();

            // Adding Markers on Google Map for each matching address
            for(int i=0;i<addresses.size();i++){

                Address address = addresses.get(i);

                // Creating an instance of GeoPoint, to display in Google Map
                latLng = new LatLng(address.getLatitude(), address.getLongitude());

                String Location = address.getLocality();
                String zip = address.getPostalCode();
                double ss=address.getLatitude ();
                lati=Double.toString (ss);
                double ss1=address.getLongitude ();
                longi=Double.toString (ss1);

                String addressText =address.getAddressLine (i);
                addrs=addressText;


                markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(addressText);





                mMap.addMarker(markerOptions);
                // mMap.setOnMapClickListener ((GoogleMap.OnMapClickListener) this);
                // mMap.setOnInfoWindowClickListener (mm1);

                // Locate the first location
                if(i==0)
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                //mMap.setOnInfoWindowClickListener ((GoogleMap.OnInfoWindowClickListener) this);
            }

        }
    }

    /*private void LocationtUser(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter
        //Creating object for our interface
        RegisterAPI2 api = adapter.create(RegisterAPI2.class);
        //Defining the method insertuser of our interface
        api.LocationUser(
                //Passing the values by getting it from editTexts
                addrs,
                longi,
                lati,
                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;
                        //An string to store output from the server
                        String output = "";
                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        Toast.makeText(GoogleMap1.this, output, Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(GoogleMap1.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        //Here we will handle the http request to insert user to mysql db
    }*/




}



