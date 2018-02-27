package com.example.mara.roomiez.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mara on 2/27/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragmets = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmets.get(position);
    }

    @Override
    public int getCount() {
        return fragmets.size();
    }

    public void addFragment(Fragment f){
        fragmets.add(f);
    }
}
