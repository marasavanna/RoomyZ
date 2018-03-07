package com.example.mara.roomiez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;


public class ApartmentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;

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
        GalleryAdapter adapter = new GalleryAdapter(this, images, R.layout.image_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ApartmentDetailsActivity.this, GalleryActivity.class));
            }
        });
        viewPager.setAdapter(adapter);
        viewPager.setOnClickListener(this);
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
