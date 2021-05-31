package com.example.contactapp.Quanly;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.contactapp.Quanly.HomeQuanly.Home_Quanly;
import com.example.contactapp.Quanly.QuanlyProfile.QuanlyProfile;
import com.example.contactapp.Quanly.YourClass.YourClass;

public class ViewpagerAdapterQuanly extends FragmentStatePagerAdapter {
    ViewPager viewPager;
    public ViewpagerAdapterQuanly(@NonNull FragmentManager fm, int behavior,ViewPager viewPager) {
        super(fm, behavior);
        this.viewPager=viewPager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Home_Quanly(viewPager);
            case 1: return new YourClass();
            case 2: return new QuanlyProfile();
            default: return new Home_Quanly(viewPager);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
