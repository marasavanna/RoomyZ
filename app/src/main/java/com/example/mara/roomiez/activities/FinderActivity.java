package com.example.mara.roomiez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.CardAdapter;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

public class FinderActivity extends AppCompatActivity implements CardStackView.CardEventListener {

    private CardStackView cards;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder);

        cardAdapter = new CardAdapter(this);
        cardAdapter.add(R.drawable.apartment_1);
        cardAdapter.add(R.drawable.apartment_2);
        cardAdapter.add(R.drawable.apartment_3);
        cardAdapter.add(R.drawable.apartment_4);
        cardAdapter.add(R.drawable.apartment_5);
        cardAdapter.add(R.drawable.apartment_6);
        cardAdapter.add(R.drawable.apartment_7);
        cardAdapter.add(R.drawable.apartment_8);
        cardAdapter.add(R.drawable.apartment_9);

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
