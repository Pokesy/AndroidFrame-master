package com.loonggg.androidframedemo.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.loonggg.androidframedemo.app.CustomApp;


/**
 *
 *
 */
public class ToastUtil {

    private ToastUtil() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(CustomApp.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CustomApp.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    public static void show(@StringRes int resId) {
        show(CustomApp.getInstance().getString(resId));
    }

}