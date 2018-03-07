package com.example.mara.roomiez.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mara.roomiez.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Akitektuo on 06.03.2018.
 */

public class GalleryAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Integer> pictureIds;
    private int layout;
    private View.OnClickListener clickListener;

    public GalleryAdapter(Context context, List<Integer> ids, int layout, View.OnClickListener clickListener) {
        this.context = context;
        this.pictureIds = ids;
        this.layout = layout;
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return pictureIds.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(layout, container, false);
        if (layout == R.layout.image_item) {
            ImageView image = v.findViewById(R.id.image_item_gallery);
            Picasso.with(context).load(pictureIds.get(position)).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);
//            image.setImageResource(pictureIds.get(position));
            image.setOnClickListener(clickListener);

        } else {
            PhotoView image = v.findViewById(R.id.image_gallery);
            Picasso.with(context).load(pictureIds.get(position)).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);
//            image.setImageResource(pictureIds.get(position));
            image.setOnClickListener(clickListener);
        }
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
