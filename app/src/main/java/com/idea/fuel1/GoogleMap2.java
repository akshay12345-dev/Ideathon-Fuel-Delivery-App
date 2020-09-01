package com.idea.fuel1;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.location.Address;

import java.text.DecimalFormat;
import java.util.List;
import android.location.Geocoder;

import java.io.IOException;

import java.util.Locale;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;


import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;



public class GoogleMap2 extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    //public static final String ROOT_URL = "http://192.168.43.61:8082/Example1";
    String addrs;
    String longi;
    String lati;
    double dd1;
    double newLat;
    double newLong;
    double distance;
    double distance1;
    double lati1=0.0;
    double longi1=0.0;


    LatLng latlng1,latlng2;
    LocationManager locationManager;
    LocationListener locationListener;
    Location currentLocation;
    Marker marker1;

    String fullAdd=null;
    String ss5;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int FOREGROUND_ID = 1337;
    private static final double EARTH_RADIUS = 6371000f;

    private static final int REQUEST_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map1);
        locationManager=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener=new LocationListener ( ) {
            @Override
            public void onLocationChanged(Location location) {
               // newLat=location.getLatitude ();
               // newLong=location.getLongitude ();
               // double lati1=Double.parseDouble (lati);
               // double longi1=Double.parseDouble (longi);

               lati1=29.736891;
               longi1=79.456451;
                distance= getDistance(newLat,newLong,lati1,longi1);
                Toast.makeText (getApplicationContext (),"Distance is "+String.valueOf (distance),Toast.LENGTH_LONG).show ();


            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
    }
    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    newLat=currentLocation.getLatitude ();
                    newLong=currentLocation.getLongitude ();
                    Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();

                    //Toast.makeText(GoogleMap2.this,"Distance is "+String.valueOf (distance1),Toast.LENGTH_SHORT).show ();
                    //Log.i ("deliver is",String.valueOf (distance1));
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(GoogleMap2.this);
                }
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        latlng2=new LatLng (18.6523,73.8526);

        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(getAddress (getApplicationContext (),latLng.latitude,latLng.longitude));
        markerOptions.icon (BitmapDescriptorFactory.defaultMarker (BitmapDescriptorFactory.HUE_YELLOW));
        distance1=CalculationByDistance (latLng,latlng2);
        Log.i("deliver2 is",String.valueOf (distance1));
        if(distance1<4.00000000000)
        {

          // googleMap.addMarker (new MarkerOptions ().position (latlng2).title (getAddress (getApplicationContext (),latlng2.latitude,latlng2.longitude)));
            //googleMap.moveCamera (CameraUpdateFactory.newLatLng (latlng2));
            MarkerOptions markerOptions1 = new MarkerOptions().position(latlng2).title(getAddress (getApplicationContext (),latlng2.latitude,latlng2.longitude));
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng2));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng2, 5));
            googleMap.addMarker(markerOptions1);
            marker1=googleMap.addMarker (markerOptions1);

        }
       // MarkerOptions markerOptions1 = new MarkerOptions().position(latLng).title(getAddress (getApplicationContext (),latLng.latitude,latLng.longitude,));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
        googleMap.addMarker(markerOptions);
        marker1=googleMap.addMarker (markerOptions);
        googleMap.setOnMarkerClickListener (this);




    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }
    public String getAddress(Context ctx, double lat, double lng){

        try{
            Geocoder geocoder= new Geocoder(ctx, Locale.getDefault());
            List<android.location.Address> addresses = geocoder.getFromLocation(lat,lng,1);
            if(addresses.size()>0){
                Address address = addresses.get(0);
                fullAdd = address.getAddressLine(0);
                addrs=fullAdd;
                double bb=address.getLongitude ();
                double bb1=address.getLatitude ();
                latlng1=new LatLng (address.getLatitude (),address.getLongitude ());
                //latlng2=new LatLng (18.6060963,73.8227827);
               /* distance1=CalculationByDistance(latlng1,latlng2);
                //distances2=Double.toString (distance1);
                if(distance1<2.0000000)
                {
                    Geocoder geocoder3;
                    List<Address> addresses1;
                    geocoder3 = new Geocoder(this, Locale.getDefault());
                    addresses1=geocoder3.getFromLocation (latlng2.latitude,latlng2.longitude,1);
                    String sslp=addresses1.get (0).getAddressLine (0);
                    return sslp;

                }*/
                //Toast.makeText(GoogleMap2.this,"Distance is "+String.valueOf (distance1)+"km",Toast.LENGTH_LONG).show ();

               // Toast.makeText(GoogleMap2.this,"Distance is "+String.valueOf (dd1)+"km",Toast.LENGTH_LONG).show ();

                longi=Double.toString (bb);
                lati=Double.toString (bb1);
                ss5=fullAdd;

                // if you want only city or pin code use following code //
                   /* String Location = address.getLocality();
                    String zip = address.getPostalCode();
                    String Country = address.getCountryName(); */
            }


        }catch(IOException ex){
            ex.printStackTrace();
        }
        return fullAdd;
    }





    /*public void LocationtUser(){
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
                new Callback <Response> () {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader (result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(google_map_2.this, output, Toast.LENGTH_LONG).show();
                    }


                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(google_map_2.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );


        //Here we will handle the http request to insert user to mysql db
    }*/


    @Override
    public boolean onMarkerClick(Marker marker) {
       // LocationtUser ();
        return false;
    }
    public double getDistance(double lat1, double lon1, double lat2, double lon2){
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double lat11=51.5007;
        double lon12=0.1246;
        double lat21=40.6892;
        double lon22=74.0445;
        double dlat1=Math.toRadians (lat21-lat11);
        double dlon2=Math.toRadians (lon22-lon12);
        double a = Math.pow(Math.sin(dlat1 / 2), 2) +
                Math.pow(Math.sin(dlon2 / 2), 2) *
                        Math.cos(lat11) *
                        Math.cos(lat21);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        double dd1=rad*c;

        Log.i("Distance is",String.valueOf (dd1));
        return rad * c;



        /*double a = Math.sin(dlat1/2) * Math.sin(dlat1/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat21)) *
                        Math.sin(dlon2/2) * Math.sin(dlon2/2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS * c;*/
    }public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat ("####");
        int kmInDec = Integer.parseInt (newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.parseInt (newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);
         dd1=Radius*c;
        Log.i ("Distance is", String.valueOf (dd1));

        return Radius * c;
    }


}
