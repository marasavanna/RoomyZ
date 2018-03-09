package com.example.mara.roomiez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.activities.ApartmentDetailsActivity;
import com.example.mara.roomiez.adapters.CardAdapter;
import com.example.mara.roomiez.database.model.Apartment;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mara on 2/27/2018.
 */

public class ApartmentsFragment extends Fragment implements CardStackView.CardEventListener {

    private CardStackView cards;
    private CardAdapter cardAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_apartment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cardAdapter = new CardAdapter(getContext());
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
        cards = getActivity().findViewById(R.id.stack_apartments);
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
        startActivity(new Intent(getContext(), ApartmentDetailsActivity.class));
    }
}
