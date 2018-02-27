package com.example.mara.roomiez.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mara.roomiez.R;

/**
 * Created by Mara on 2/25/2018.
 */

public class SlideAdapter extends PagerAdapter implements View.OnClickListener{

    private Context ctx;
    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickGoogle;
    private View.OnClickListener onClickFacebook;

    public SlideAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public SlideAdapter(Context ctx, View.OnClickListener onClickGoogle, View.OnClickListener onClickFacebook) {
        this.ctx = ctx;
        this.onClickGoogle = onClickGoogle;
        this.onClickFacebook = onClickFacebook;
    }

    public int[] slide_images = {R.drawable.deal, R.drawable.home, R.drawable.roomies};
    public String[] slide_texts = {
            "Give your apartment to rent or rent an apartment without any agencies!",
            "Find the home that suits you best!",
            "Choose the perfect roomies and make friends!"
    };
    @Override
    public int getCount() {
        return slide_texts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView  = v.findViewById(R.id.image_slider);
        TextView slideTextView = v.findViewById(R.id.slide_text);

        slideImageView.setImageResource(slide_images[position]);
        slideTextView.setText(slide_texts[position]);
        v.findViewById(R.id.google_login).setOnClickListener(onClickGoogle);
        v.findViewById(R.id.facebook_login).setOnClickListener(onClickFacebook);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public void onClick(View view) {

    }
}
