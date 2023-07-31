package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TabAdapter extends FragmentStatePagerAdapter {
    ArrayList<MyTab> tabs;
    public TabAdapter(@NonNull FragmentManager fm, ArrayList<MyTab> tabs) {
        super(fm);
        this.tabs = tabs;
    }

    public void addTab(MyTab tab)
    {
       tabs.add(tab);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getCategory().getName();
    }
}
