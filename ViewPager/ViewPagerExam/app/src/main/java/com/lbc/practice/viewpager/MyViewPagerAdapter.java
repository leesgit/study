package com.lbc.practice.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by lbc on 2018-01-16.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    int images[] = {R.drawable.ic_audiotrack_black_24dp,R.drawable.ic_insert_emoticon_black_24dp,R.drawable.ic_android_black_24dp};

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(images[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
