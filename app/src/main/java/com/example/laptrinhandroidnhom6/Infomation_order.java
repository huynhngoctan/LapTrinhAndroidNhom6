package com.example.laptrinhandroidnhom6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.laptrinhandroidnhom6.map.MyMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Infomation_order extends Activity implements OnMapReadyCallback {
    Button btnBack;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_order);
//        btnBack = findViewById(R.id.btnReturn);
        //map

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mymap);
        mapFragment.getMapAsync(this);
        //event btn back
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentBack = new Intent(Infomation_order.this,Cart.class);
//                startActivity(intentBack);
//            }
//        });
    }

    @Override
    public void onMapReady( GoogleMap googleMap) {
        LatLng syd  = new LatLng(-33.867,151.206);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syd,13));
        googleMap.addMarker(new MarkerOptions().title("cuong")
        .snippet("cuong123")
                .position(syd)
        );
    }
}
