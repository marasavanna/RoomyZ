package com.example.mara.roomiez;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dots;
    private SlideAdapter adapter;

    private TextView[] myDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.slide_view_pager);
        dots = findViewById(R.id.dots);

        adapter = new SlideAdapter(this);

        viewPager.setAdapter(adapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

    }

    public void addDotsIndicator(int position){

        dots.removeAllViews();

        myDots = new TextView[3];

        dots.removeAllViews();
        myDots = new TextView[3];

        for(int i = 0; i < myDots.length; i++){
            myDots[i] = new TextView(this);
            myDots[i].setText(Html.fromHtml("&#8226;"));
            myDots[i].setTextSize(35);
            myDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            dots.addView(myDots[i]);
        }

        if(myDots.length > 0){
            myDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
