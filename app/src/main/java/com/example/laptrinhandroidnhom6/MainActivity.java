package com.example.laptrinhandroidnhom6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.laptrinhandroidnhom6.profile.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity  extends AppCompatActivity  {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ViewPagerAdater viewPagerAdater = new ViewPagerAdater(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdater);
        checkFragment();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_order).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_notification).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menu_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_order:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_notification:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_profile:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }
    public void checkFragment(){
        Intent intent = getIntent() ;
        String profileFragment = intent.getStringExtra("profile");
        int number = intent.getIntExtra("number",1) ;

        if(profileFragment!=null){
            viewPager.setCurrentItem(number);
            bottomNavigationView.getMenu().findItem(R.id.menu_profile).setChecked(true);
        }
    }


}