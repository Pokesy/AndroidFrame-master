package com.loonggg.androidframedemo.utils;

import android.content.Context;

/**
 * Density的工具类
 * 
 * context.getResources().getDisplayMetrics():返回的是一个DisplayMetrics对象，
 * 
 * DisplayMetrics类里重要参数：
 * 
 * density：设备密度，设备比例 scaledDensity: px转sp会用到。 公式： sp = px / scaledDensity;
 * heightPixels:屏幕的高度 widthPixels:屏幕的宽
 * 
 * 
 * @author Administrator
 * 
 *         dp=px/设备密度
 */
public class DensityUtil {

	/**
	 * px 转到 dp
	 * 
	 * @param context
	 * @param px
	 * @return
	 */
	public static float px2dp(Context context, int px) {
		// 得到设备密度，设备比例
		float density = context.getResources().getDisplayMetrics().density;
		return px / density;
	}

	/**
	 * dp 转到 px
	 * 
	 * 4.9 4.6+0.5=5.1f
	 * 
	 * @param context
	 * @param dp
	 * @return
	 */
	public static int dp2px(Context context, float dp) {
		float density = context.getResources().getDisplayMetrics().density;
		return (int) (dp * density + 0.5f);
	}
}
