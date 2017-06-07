package com.qsfan.qsfutils.utils;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

/**
 * Author:ShaoJian.
 * DATA:${DATA}
 * ACTION:处理权限
 * TYPE:工具类
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
class PermissionUtil {
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    static final String CAMERA = Manifest.permission.CAMERA;
    static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    static final int PERMISSION_DIALOG = 0;
    static final int PERMISSION_AUTO = 1;
    private static final int PERMISSION_THROUGH = 2;
    private static final int PERMISSION_UN_REQUIRE = 3;

    public static final int PERMISSION_REQUEST_READ_CONTACTS = 0;
    public static final int PERMISSION_REQUEST_WRITE_CONTACTS = 1;
    public static final int PERMISSION_REQUEST_READ_CALL_LOG = 2;
    public static final int PERMISSION_REQUEST_WRITE_CALL_LOG = 3;
    static final int PERMISSION_REQUEST_CAMERA = 4;
    static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 5;

    public PermissionUtil() {

    }

    private static int check(Activity context, String permissionName) {
        int ret = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //String[] REQUEST_PERMISSIONS = new String[]{permissionName};
            if (context.checkSelfPermission(permissionName) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context, permissionName)) {
                    ret = PERMISSION_DIALOG;
                    /*ToastUtils.show(context, "部分权限受到限制，可能会影响您的使用，您可以去应用管理或者手机管家打开哦！");*/
                } else {
                    ret = PERMISSION_AUTO;
                    /*ActivityCompat.requestPermissions(context, REQUEST_PERMISSIONS, PERMISSION_REQUEST);*/
                }
            } else {
                ret = PERMISSION_THROUGH;
            }
        } else {
            ret = PERMISSION_UN_REQUIRE;
        }
        return ret;
    }

    /**
     * 要添加权限的列表
     *
     * @param context
     * @param permissionName
     * @param PERMISSION_REQUEST
     */
    public static void checkPermission(Activity context, ArrayList<String> permissionName, int
            PERMISSION_REQUEST) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        ArrayList<String> addList = new ArrayList<String>();
        boolean point = false;
        for (String perName : permissionName) {
            int ret = check(context, perName);
            if (ret == PERMISSION_AUTO) {
                addList.add(perName);
            } else if (ret == PERMISSION_DIALOG) {
                point = true;
            }
        }
        if (addList.size() > 0) {
            String[] strings = new String[addList.size()];
            ActivityCompat.requestPermissions(context, addList.toArray(strings), PERMISSION_REQUEST);
        }
        if (point) {
            //ToastUtils.show(context, "部分权限受到限制，可能会影响您的使用，您可以去应用管理或者手机管家打开哦！");
        }
    }


    /**
     * 检查Dangerous的单个权限
     *
     * @param context
     * @param permissionName
     * @param PERMISSION_REQUEST
     * @return
     */
    static int checkSignalPermission(Activity context, String permissionName, int
            PERMISSION_REQUEST) {
        int ret = PERMISSION_UN_REQUIRE;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return ret;
        }
        ret = check(context, permissionName);
        if (ret == PERMISSION_AUTO) {
            String[] strings = new String[]{permissionName};
            ActivityCompat.requestPermissions(context, strings, PERMISSION_REQUEST);
        }
        return ret;
    }


    /**
     * 如果双重权限具备返回true
     *
     * @param context
     * @param pName1
     * @param pName2
     * @return
     */
    public static boolean checkDoublePer(Activity context, String pName1, String pName2) {
        //Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS
        int p1 = PermissionUtil.check(context, pName1);
        int p2 = PermissionUtil.check(context, pName2);
        return p1 == PermissionUtil.PERMISSION_THROUGH && p2 == PermissionUtil.PERMISSION_THROUGH;
    }

    /**
     * 判断网络是否可用
     */
    static boolean hasNetWork(Context mContext) {
        Context context = mContext.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        // 获取NetworkInfo对象
        NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo aNetworkInfo : networkInfo) {
            if (aNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }
}
