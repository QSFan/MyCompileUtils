package com.qsfan.mycompileutils;

import android.app.Application;

import com.qsfan.bgalibrary.BGASwipeBackManager;
import com.qsfan.qsfutils.utils.Utils;

/**
 * =============版权所有===============
 * <p/>
 * 类注释:
 * 作者: QSFan
 * 邮箱: qsfan_vip.163.com
 * 时间: 2017/4/19 9:33
 * 版本:
 * 备注：
 * ==============版权所有===============
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        BGASwipeBackManager.getInstance().init(this);
        Utils.init(this);
    }
}
