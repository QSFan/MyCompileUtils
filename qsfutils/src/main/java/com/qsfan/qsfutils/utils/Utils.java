package com.qsfan.qsfutils.utils;

import android.content.Context;

/**
 * ==============版权所有===============
 *
 * 类注释: Utils初始化相关
 * 作者: QSFan
 * 邮箱: qsfan_vip.163.com
 * 时间: 2017/4/19 11:55
 * 版本:
 * 备注：
 * ==============版权所有===============
*/
public final class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}