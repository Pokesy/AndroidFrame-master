package com.loonggg.androidframedemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.Contact;
import com.loonggg.androidframedemo.adapter.ContactsAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.view.RGridView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 */

public class HostFragment extends BasicFragment {


    @Bind(R.id.rv_contacts)
    RecyclerView rvContacts;
    @Bind(R.id.side_bar)
    WaveSideBar sideBar;
    @Bind(R.id.activity_car_model_lib)
    LinearLayout activityCarModelLib;
    @Bind(R.id.rm_listView)
    RGridView rmListView;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_host, null);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    private void initView() {
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContacts.setAdapter(new ContactsAdapter(contacts, R.layout.item_contacts));
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) rvContacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    private void initData() {
        contacts.addAll(Contact.getEnglishContacts());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
