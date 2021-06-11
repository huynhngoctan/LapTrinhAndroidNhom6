package com.example.laptrinhandroidnhom6;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.laptrinhandroidnhom6.profile.Profile;

public class ViewPagerAdater extends FragmentStatePagerAdapter {


    public ViewPagerAdater(@NonNull  FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return  new Home();
            case 1: return  new ListOrder_Fragment();
            case 2: return  new Notification_Fragment();
            case 3: return  new Profile();
            default: return new Home();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
