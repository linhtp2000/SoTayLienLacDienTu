package com.example.contactapp.Quanly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.example.contactapp.R;
import com.google.android.material.tabs.TabLayout;

public class Quanly extends AppCompatActivity {
    private TabLayout mtablayoutQuanly;
    private ViewPager viewPagerQuanly;
    private int[] tabIcons = {
            R.drawable.ic_home,R.drawable.ic_schedule,R.drawable.ic_user
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly);
        mtablayoutQuanly=findViewById(R.id.tablayoutquanly);
        viewPagerQuanly=findViewById(R.id.ViewpagerQuanly);
        ViewpagerAdapterQuanly viewPagerAdapter= new ViewpagerAdapterQuanly(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,viewPagerQuanly);
        viewPagerQuanly.setAdapter(viewPagerAdapter);
        mtablayoutQuanly.setupWithViewPager(viewPagerQuanly);
        setupTabIcons();
        mtablayoutQuanly.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.Yellow), PorterDuff.Mode.SRC_IN);
        mtablayoutQuanly.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        mtablayoutQuanly.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);

        mtablayoutQuanly.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.Yellow), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void setupTabIcons() {
        mtablayoutQuanly.getTabAt(0).setIcon(tabIcons[0]);
        mtablayoutQuanly.getTabAt(1).setIcon(tabIcons[1]);
        mtablayoutQuanly.getTabAt(2).setIcon(tabIcons[2]);
    }
}