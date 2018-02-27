package com.example.mara.roomiez.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.ViewPagerAdapter;
import com.example.mara.roomiez.fragments.ProfileFragment;

public class TabNavigationActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private ViewPager container;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_navigation);



        container = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment());

        container.setAdapter(adapter);
        tabLayout.setupWithViewPager(container);
        tabLayout.addOnTabSelectedListener(this);
        setUpTabIcons();




    }

    public void setUpTabIcons(){
        tabLayout.getTabAt(0).setIcon(R.drawable.unselected_user);
       // tabLayout.getTabAt(1).setIcon(R.drawable.unselected_settings);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch(tab.getPosition()){
            case 0:
                tab.setIcon(R.drawable.selected_user);
                break;
           /* case 1:
                tab.setIcon(R.drawable.selected_settings);
                break;
                */
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        switch(tab.getPosition()){
            case 0:
                tab.setIcon(R.drawable.unselected_user);
                break;
            /*case 1:
                tab.setIcon(R.drawable.unselected_settings);
                break;
                */
        }
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
