package com.loonggg.androidframedemo.net.constant;

import android.app.AlertDialog;
import android.app.Dialog;

/**
 * Created by Administrator on 2017/5/27.
 * 修云飞  用于返回对话框中的确定与取消操作返回
 */

public interface SureAndCancelInterface {

    void returnSure(String sure, AlertDialog sureDialog);

    void returnCancel(String cancel, AlertDialog cancelDialog);
}
