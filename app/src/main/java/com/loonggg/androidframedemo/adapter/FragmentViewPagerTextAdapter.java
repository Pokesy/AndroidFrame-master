package com.loonggg.androidframedemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
public class FragmentViewPagerTextAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private List<String> mDat;
    public FragmentViewPagerTextAdapter(FragmentManager fm, List<Fragment> list, List<String> mDat) {
        super(fm);
        this.list = list;
        this.mDat=mDat;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position+1);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mDat.get(position);
    }
}
