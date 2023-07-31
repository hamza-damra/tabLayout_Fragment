package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager2);



        ArrayList<MyTab> tabs = new ArrayList<>(3);
        tabs.add(new MyTab(new Category(1,"Food"),CategoryFragment.newInstance(1,"Food")));
        tabs.add(new MyTab(new Category(2,"Drinks"),CategoryFragment.newInstance(2,"Drinks")));
        tabs.add(new MyTab(new Category(3,"Deserts"),CategoryFragment.newInstance(3,"Deserts")));
        TabAdapter categoryAdapter = new TabAdapter(getSupportFragmentManager(),tabs);
        viewPager.setAdapter(categoryAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getBaseContext(), "tab selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(getBaseContext(), "tab Unselected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(getBaseContext(), "tab Reselected", Toast.LENGTH_SHORT).show();
            }
        });

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }
}