package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class BrandViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{ "主机","配套件"};
    private Context context;

    public BrandViewPagerAdapter(FragmentManager fm, List<Fragment> list, Context context) {
        super(fm);
        this.list = list;
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}