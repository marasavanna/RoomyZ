package com.example.mara.roomiez.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.GalleryAdapter;
import com.example.mara.roomiez.database.model.Apartment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class ApartmentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TextView textRooms;
    private TextView textNeighborhood;
    private TextView textPrice;
    private TextView textSurface;
    private TextView textBathrooms;
    private TextView textBalconies;
    private TextView textParking;
    private TextView textPets;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_details);

        viewPager = findViewById(R.id.pager_gallery);
        List<Integer> images = new ArrayList();
        images.add(R.drawable.apartment_1);
        images.add(R.drawable.apartment_2);
        images.add(R.drawable.apartment_3);
        images.add(R.drawable.apartment_4);
        images.add(R.drawable.apartment_5);
        images.add(R.drawable.apartment_6);
        images.add(R.drawable.apartment_7);
        images.add(R.drawable.apartment_8);
        images.add(R.drawable.apartment_9);
        Apartment apartment = new Apartment(images, "", new Random().nextInt(4) + 1,
                "Zorilor", new Random().nextFloat() + new Random().nextInt(2400) + 100,
                "EUR", new Random().nextFloat() + new Random().nextInt(90) + 10,
                new Random().nextInt(3) + 1, new Random().nextInt(3),
                new Random().nextBoolean(), new Random().nextBoolean(), getString(R.string.long_string), null);
        GalleryAdapter adapter = new GalleryAdapter(this, images, R.layout.image_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ApartmentDetailsActivity.this, GalleryActivity.class));
            }
        });
        viewPager.setAdapter(adapter);
        viewPager.setOnClickListener(this);

        textRooms = findViewById(R.id.text_detailed_rooms);
        textNeighborhood = findViewById(R.id.text_detailed_neighborhood);
        textPrice = findViewById(R.id.text_detailed_price);
        textSurface = findViewById(R.id.text_detailed_surface);
        textBathrooms = findViewById(R.id.text_detailed_bathrooms);
        textBalconies = findViewById(R.id.text_detailed_balcony);
        textParking = findViewById(R.id.text_detailed_parking);
        textPets = findViewById(R.id.text_detailed_pets);
        textDescription = findViewById(R.id.text_detailed_description);

        textRooms.setText(getString(R.string.rooms, apartment.rooms));
        textNeighborhood.setText(getString(R.string.neighborhood, apartment.adress));
        textPrice.setText(getString(R.string.price, apartment.price, apartment.currency));
        textSurface.setText(getString(R.string.surface, apartment.surface));
        textBathrooms.setText(getString(R.string.bathrooms, apartment.bathrooms));
        textBalconies.setText(getString(R.string.balconies, apartment.balconies));
        textParking.setText(getString(R.string.parking, apartment.parking ? "YES" : "NO"));
        textPets.setText(getString(R.string.pets, apartment.pets ? "YES" : "NO"));
        textDescription.setText(apartment.description);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        for (String provider : locationManager.getAllProviders()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            System.out.println("Location is " + locationManager.getLastKnownLocation(provider).getLatitude());
            Location location = locationManager.getLastKnownLocation(provider);
            getAddress(location.getLatitude(), location.getLongitude());
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pager_gallery:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
        }
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void getAddress(double lat, double lng) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);
            String add = obj.getAddressLine(0);
            add = add + "\n" + obj.getCountryName();
            add = add + "\n" + obj.getCountryCode();
            add = add + "\n" + obj.getAdminArea();
            add = add + "\n" + obj.getPostalCode();
            add = add + "\n" + obj.getSubAdminArea();
            add = add + "\n" + obj.getLocality();
            add = add + "\n" + obj.getSubThoroughfare();

            Log.v("IGA", "Address" + add);
            // Toast.makeText(this, "Address=>" + add,
            // Toast.LENGTH_SHORT).show();

            // TennisAppActivity.showDialog(add);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
