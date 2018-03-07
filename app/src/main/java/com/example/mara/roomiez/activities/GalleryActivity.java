package com.example.mara.roomiez.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView buttonBack, imageBackground;
    private boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);
        ViewPager gallery = findViewById(R.id.view_gallery);
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
        buttonBack = findViewById(R.id.button_gallery_back);
        imageBackground = findViewById(R.id.image_gallery_background);
        buttonBack.setOnClickListener(this);
        GalleryAdapter adapter = new GalleryAdapter(this, images, R.layout.gallery_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isVisible) {
                    imageBackground.setVisibility(View.GONE);
                    buttonBack.setVisibility(View.GONE);
                } else {
                    imageBackground.setVisibility(View.VISIBLE);
                    buttonBack.setVisibility(View.VISIBLE);
                }
                isVisible = !isVisible;
            }
        });
        gallery.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_gallery_back:
                finish();
                break;
        }
    }
}
