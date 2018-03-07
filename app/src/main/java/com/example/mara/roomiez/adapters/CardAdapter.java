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
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * Created by Akitektuo on 06.03.2018.
 */

public class CardAdapter extends ArrayAdapter<Integer> {

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
        Picasso.with(context).load(getItem(position)).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.image);
//        holder.image.setImageResource(getItem(position));
        return contentView;
    }

    private class ViewHolder {
        public ImageView image;

        public ViewHolder(View view) {
            image = view.findViewById(R.id.image_apartment);
        }

    }

}
