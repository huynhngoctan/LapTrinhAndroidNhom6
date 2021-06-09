package com.example.laptrinhandroidnhom6.list_order;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.laptrinhandroidnhom6.Home_Fragment;
import com.example.laptrinhandroidnhom6.ListOrder_Fragment;
import com.example.laptrinhandroidnhom6.Notification_Fragment;
import com.example.laptrinhandroidnhom6.Profile_Fragment;

public class PagerAdepterOrder extends FragmentStatePagerAdapter {


    public PagerAdepterOrder(@NonNull  FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return  new OrderFagment();
            case 1: return  new ComingFagment();
            default: return new OrderFagment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return  "Lịch sử";
            case 1: return  "Đang đến";
            default: return "Lịch sử";
        }
    }
}
