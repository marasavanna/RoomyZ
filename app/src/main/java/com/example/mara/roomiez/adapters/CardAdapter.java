package com.example.mara.roomiez.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.mara.roomiez.R;

/**
 * Created by Akitektuo on 06.03.2018.
 */

public class CardAdapter extends ArrayAdapter<Integer> {

    public CardAdapter(@NonNull Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View contentView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.card_layout, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }
        holder.image.setImageResource(getItem(position));
        return contentView;
    }

    private class ViewHolder {
        public ImageView image;

        public ViewHolder(View view) {
            image = view.findViewById(R.id.image_apartment);
        }

    }

}
