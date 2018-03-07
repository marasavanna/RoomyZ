package com.example.mara.roomiez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.GalleryAdapter;
import com.example.mara.roomiez.database.model.Apartment;

import java.util.ArrayList;
import java.util.List;
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
}
