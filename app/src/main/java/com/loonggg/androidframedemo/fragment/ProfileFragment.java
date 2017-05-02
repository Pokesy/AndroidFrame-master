package com.loonggg.androidframedemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 */

public class ProfileFragment extends BasicFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, null);
    }
}
