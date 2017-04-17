package com.qsfan.qsfutils.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qsfan.qsfutils.R;



/**
 * Created by Administrator on 2016/8/4.
 */
public class PublicUtils {
    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
//            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    /**
     * 检查是否有网络
     *
     * @param context
     */
    public static void OpenNetworkSetting(final Context context) {
        // 检查有没有网络
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        //模拟器是用电脑上网，有可能设置飞行模式activeNetworkInfo！=null
        //在真机测试。真机也要上网
        //用一台笔记本电脑，做wifi连接
        if (activeNetworkInfo == null) {
            // 没网，显示一个dialog,
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setMessage("亲，现在你没网");
            // 打开
            dialog.setPositiveButton("打开", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        //不同的android版本网络设置界面activity中的intent-filetr,action是不一样的
                        //不同的android版本的代码是不一样的。
                        int androidVersion = android.os.Build.VERSION.SDK_INT;
                        //通过代码得到手机厂商名称，
                        //不同厂商的手机的代码是不一样的。
                        //有的手机能得到手机号，大部分手机能得到sim卡中的串号，串号每个手机是唯一的。
                        if (androidVersion >= 10) {
                            // 打开系统自带的网络设置界面
                            Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                            context.startActivity(intent);
                        }

                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }

            });
            // 取消
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    dialog.cancel();
                }

            });
            dialog.show();
        }
    }


    /**
     * 倒计时
     *
     * @param view 控件
     * @param meg  倒计时结束需要展示的文字
     */
    public static void downTime(final TextView view, final String meg) {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                view.setText(millisUntilFinished / 1000 + "秒");
                view.setEnabled(false);
            }

            @Override
            public void onFinish() {
                view.setEnabled(true);
                view.setText(meg);
            }
        };

        countDownTimer.start();
    }

    /**
     * 使用Glide加载图片
     *
     * @param context
     * @param url       图片地址
     * @param imageView 加载图片控件
     */
    public static void setNetImage(Context context, String url, ImageView imageView) {
        if (url != null && !url.isEmpty()) {
            String substring = url.substring(0, 4);
            if (substring.equals("http")) {
                Glide.with(context).load(url)
//                        .skipMemoryCache(true)//跳过加载到内存
                        .asBitmap()
                        .placeholder(R.drawable.waiting)//设置默认图片
                        .error(R.drawable.waiting)//设置加载错误图片
                        .into(imageView);
            } else {
                Glide.with(context).load(url)
//                        .skipMemoryCache(true)
                        .asBitmap()
                        .placeholder(R.drawable.waiting)//设置默认图片
                        .error(R.drawable.waiting)//设置加载错误图片
                        .into(imageView);
            }
        }
    }

}
