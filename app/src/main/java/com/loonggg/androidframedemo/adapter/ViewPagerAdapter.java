package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.loonggg.androidframedemo.fragment.HomeFragment;
import com.loonggg.androidframedemo.fragment.MainFragment;
import com.loonggg.androidframedemo.fragment.NewsFragment;
import com.loonggg.androidframedemo.fragment.PeopleFragment;
import com.loonggg.androidframedemo.fragment.RefreshRecyclerViewFragment;
import com.loonggg.androidframedemo.fragment.VedioFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    final int PAGE_COUNT = 6;
    private String tabTitles[] = new String[]{"", "新闻", "视频", "促销", "活动","人物"};
    private Context context;


    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new HomeFragment();
        else if (position == 1)
            return new NewsFragment();
        else if (position == 2)
            return new VedioFragment();
        else if(position==3) {
            return new NewsFragment();
        }
        else if(position==4) {
            return new NewsFragment();
        }
        else if(position==5) {
            return new PeopleFragment();
        }else {
            return new PeopleFragment();
        }
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