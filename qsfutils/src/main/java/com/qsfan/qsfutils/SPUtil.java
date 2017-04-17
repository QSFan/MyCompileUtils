package com.qsfan.qsfutils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/9.
 */
public class SPUtil {

    public static String USER_ID = "USER_ID";//用户id
    public static String USER_NAME = "USER_NAME";//用户名
    public static String USER_Mobile = "USER_MOBILE";//用户手机号
    public static String USER_MyImg = "USER_MyImg";//用户头像

    public static String USER_ID_S;

    /**
     * 获取用户id
     *
     * @param context
     * @return
     */
    public String getUId(Context context) {
        return SPUtil.getParam(context, SPUtil.USER_ID, "").toString();
    }


    /**
     * 保存在手机里面的文件名
     */
    private static final String SP_NAME = "vol_share_date";

    public static void setStringParam(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
        key = null;
        value = null;
        edit = null;
        sp = null;
        context = null;
    }

    /**
     * 保存字符串数据类型
     *
     * @param context
     * @param keys
     * @param values
     */
    public static void setStringParams(Context context, String[] keys,
                                       String[] values) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        for (int i = 0; i < keys.length; i++) {
            edit.putString(keys[i], values[i]);
        }
        keys = null;
        values = null;
        edit.commit();
        edit = null;
        sp = null;
        context = null;
    }

    /**
     * 保存所有数据类型 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void setParam(Context context, String key, Object object) {

        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        key = null;
        object = null;
        editor.commit();
        editor = null;
        sp = null;
        context = null;
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getParam(Context context, String key,
                                  Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);

        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    /**
     * 清楚sp存储的数据
     *
     * @param context
     * @param key
     * @param defaultObject
     */
    public static void clearData(Context context, String key,
                                 Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

}
