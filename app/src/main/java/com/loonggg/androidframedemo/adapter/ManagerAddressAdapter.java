package com.loonggg.androidframedemo.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.ManagerAddressModel;
import com.loonggg.androidframedemo.net.constant.SureAndCancelInterface;
import com.loonggg.androidframedemo.ui.activity.AddAddressActivity;
import com.loonggg.androidframedemo.ui.activity.ManagerAddressActivity;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */

public class ManagerAddressAdapter extends TeachBaseAdapter<ManagerAddressModel> implements View.OnClickListener {

    private Context context;

    public ManagerAddressAdapter(Context context, List<ManagerAddressModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, ManagerAddressModel item, int position) {
        TextView peopleName = (TextView) holder.getView(R.id.layout_managerAddress_peopleName);
        peopleName.setText(item.name);

        TextView peoplePhone = (TextView) holder.getView(R.id.layout_managerAddress_peoplePhone);
//        peoplePhone.setText(item);

        TextView peopleAddress = (TextView) holder.getView(R.id.layout_managerAddress_peopleAddress);
//        peopleAddress.setText(item);

        TextView defaultAddress = (TextView) holder.getView(R.id.layout_managerAddress_defaultAddress);
        //默认地址的监听事件
        defaultAddress.setTag(R.id.tag_first,defaultAddress);
        defaultAddress.setOnClickListener(this);

        //编辑按钮
        TextView compileAddress = (TextView) holder.getView(R.id.layout_managerAddress_compile);
        compileAddress.setTag(position);
        compileAddress.setOnClickListener(this);

        //删除按钮
        TextView trashAddress = (TextView) holder.getView(R.id.layout_managerAddress_trash);
        trashAddress.setTag(position);
        trashAddress.setOnClickListener(this);
    }

    //编辑，删除按钮的监听
    @Override
    public void onClick(View v) {
        TextView defaultAddress = (TextView) v.getTag(R.id.tag_first);

        final Integer tag = (Integer) v.getTag();
        switch (v.getId()) {
            //默认地址监听
            case R.id.layout_managerAddress_defaultAddress:
                if (defaultAddress.isSelected()) {
                    defaultAddress.setSelected(false);
                }else {
                    defaultAddress.setSelected(true);
                }
                break;
            //编辑按钮
            case R.id.layout_managerAddress_compile:
                ManagerAddressModel addressModel = getModel(tag);

                //跳转到添加新地址页面
                Intent intent = new Intent(context, AddAddressActivity.class);
                intent.putExtra("manager_model",addressModel);
                intent.putExtra("tag",11);
                context.startActivity(intent);
                break;
            //删除按钮
            case R.id.layout_managerAddress_trash:
                new MyUtils().ShowCustomDialog(context, R.layout.layout_address_dialog,
                        R.id.layout_addressDialog_sure, R.id.layout_addressDialog_cancel,
                        new SureAndCancelInterface() {
                            @Override
                            public void returnSure(String sure, AlertDialog sureDialog) {
                                Toast.makeText(context, "删除", Toast.LENGTH_SHORT).show();

                                //删除选中的数据，并刷新适配器
                                deleteData(tag);

                                sureDialog.dismiss();
                            }

                            @Override
                            public void returnCancel(String cancel, AlertDialog cancelDialog) {
                                Toast.makeText(context, "不删除", Toast.LENGTH_SHORT).show();
                                cancelDialog.dismiss();
                            }
                        });
                break;
        }
    }
}
