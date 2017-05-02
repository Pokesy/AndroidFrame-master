package com.loonggg.androidframedemo.ui.basic.tab;

import android.os.Message;

/**
 * Tab工具类<BR>
 */
public final class TabUtils
{
    public static Message getMessage(int msgType)
    {
        Message msg = new Message();
        msg.what = msgType;
        return msg;
    }
}
