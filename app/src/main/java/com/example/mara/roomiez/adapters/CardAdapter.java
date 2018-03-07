package com.example.mara.roomiez.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.database.model.Apartment;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by Akitektuo on 06.03.2018.
 */

public class CardAdapter extends ArrayAdapter<Apartment> {

    private Context context;

    public CardAdapter(@NonNull Context context) {
        super(context, 0);
        this.context = context;
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
        Picasso.with(context).load(getItem(position).images.get(0)).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.image);
        holder.textRooms.setText(context.getString(R.string.rooms, getItem(position).rooms));
        holder.textNeighborhood.setText(context.getString(R.string.neighborhood, getItem(position).adress));
        holder.textPrice.setText(context.getString(R.string.price, getItem(position).price, getItem(position).currency));
//        holder.image.setImageResource(getItem(position));
        return contentView;
    }

    private class ViewHolder {

        public ImageView image;
        public TextView textRooms;
        public TextView textNeighborhood;
        public TextView textPrice;

        public ViewHolder(View view) {
            image = view.findViewById(R.id.image_apartment);
            textRooms = view.findViewById(R.id.text_card_rooms);
            textNeighborhood = view.findViewById(R.id.text_card_neighborhood);
            textPrice = view.findViewById(R.id.text_card_price);
        }

    }

}
