package com.qsfan.qsfutils.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static Toast toast = null;

	/**
	 * 在主线程弹Toast
	 * @param context
	 * @param msg
     */
	public static void showTextToast(Context context, String msg) {
		if (toast == null) {
			toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
	public static void showTextToastById(Context context, int msg) {
		if (toast == null) {
			toast = Toast.makeText(context, context.getResources().getString(msg), Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}

	/**
	 * 在子线程弹Toast
	 * @param context
	 * @param msg
     */
	public static void showToastInThread(final Activity context, final String msg){
		context.runOnUiThread(new Runnable(){
			@Override
			public void run() {
				Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
			}

		});
	}
}
