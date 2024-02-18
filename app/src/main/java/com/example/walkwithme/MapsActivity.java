package com.example.walkwithme;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private CancellationToken tokenCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//TODO maybe add a internet permission check tmr, also try another update current location
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(20 * 1000);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        wayLatitude = location.getLatitude();
                        wayLongitude = location.getLongitude();
                    }
                }
            }
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(MapsActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

    }

    public double wayLatitude , wayLongitude ;
    public ArrayList<LatLng> latLngArrayList = new ArrayList<LatLng>();

    public ArrayList<String> locationNameArraylist = new ArrayList<>();
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        else{
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
        }
        fusedLocationClient.getCurrentLocation(104, tokenCancel).addOnSuccessListener(this, location -> {
            wayLatitude = location.getLatitude();
            wayLongitude = location.getLongitude();
        });
        //LatLng userLocation = new LatLng(wayLatitude,wayLongitude);
        LatLng ev1 = new LatLng(-35.2735f,149.1121f);
        LatLng ev2 = new LatLng(-35.2790f,149.1135f);
        LatLng ev3 = new LatLng(-35.2800f,149.1160f);
        LatLng ev4 = new LatLng(-35.2835f,149.1185f);
        LatLng ev5 = new LatLng(-35.2860f,149.1199f);
        latLngArrayList.add(ev1);
        latLngArrayList.add(ev2);
        latLngArrayList.add(ev3);
        latLngArrayList.add(ev4);
        latLngArrayList.add(ev5);
        locationNameArraylist.add("Running");
        locationNameArraylist.add("Walking");
        locationNameArraylist.add("Studying");
        locationNameArraylist.add("Walking");
        locationNameArraylist.add("Walking");

        //mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
        //This could be changed to user.id
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
        mMap.setMyLocationEnabled(true);
        for (int i = 0; i < latLngArrayList.size(); i++){
            mMap.addMarker(new MarkerOptions().position(latLngArrayList.get(i)).title(locationNameArraylist.get(i)));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerName = marker.getTitle();
                Toast.makeText(MapsActivity.this, "Event here is:" + markerName, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}