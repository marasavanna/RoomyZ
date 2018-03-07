package com.example.mara.roomiez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.CardAdapter;
import com.example.mara.roomiez.database.model.Apartment;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinderActivity extends AppCompatActivity implements CardStackView.CardEventListener {

    private CardStackView cards;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder);

        cardAdapter = new CardAdapter(this);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.apartment_1);
        images.add(R.drawable.apartment_2);
        images.add(R.drawable.apartment_3);
        images.add(R.drawable.apartment_4);
        images.add(R.drawable.apartment_5);
        images.add(R.drawable.apartment_6);
        images.add(R.drawable.apartment_7);
        images.add(R.drawable.apartment_8);
        images.add(R.drawable.apartment_9);
        for (int i = 0; i < 10; i++) {
            cardAdapter.add(new Apartment(images, "", new Random().nextInt(4) + 1,
                    "Zorilor", new Random().nextFloat() + new Random().nextInt(2400) + 100,
                    "EUR", new Random().nextFloat() + new Random().nextInt(90) + 10,
                    new Random().nextInt(3) + 1, new Random().nextInt(2) + 1,
                    new Random().nextBoolean(), new Random().nextBoolean(), getString(R.string.long_string), null));
        }
        cards = findViewById(R.id.stack_apartments);
        cards.setAdapter(cardAdapter);
        cards.setCardEventListener(this);
    }

    @Override
    public void onCardDragging(float percentX, float percentY) {

    }

    @Override
    public void onCardSwiped(SwipeDirection direction) {

    }

    @Override
    public void onCardReversed() {

    }

    @Override
    public void onCardMovedToOrigin() {

    }

    @Override
    public void onCardClicked(int index) {
        startActivity(new Intent(this, ApartmentDetailsActivity.class));
    }
}
