package com.example.lbc.mfcproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lbc.mfcproject.main.FragmentRank;
import com.example.lbc.mfcproject.main.FragmentSearch;

/**
 * Created by lbc on 2017-12-04.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private final static int count = 2;
    private int info;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[count];
    }

    @Override
    public Fragment getItem(int position) {
        if(fragments[position] != null)
            return fragments[position];
            switch (position) {
                case 0:
                    return fragments[0] = new FragmentRank();
                case 1:
                    return fragments[1] = new FragmentSearch();

        }
        return null;
    }

    public Fragment getFragment(int position){
        return getItem(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
