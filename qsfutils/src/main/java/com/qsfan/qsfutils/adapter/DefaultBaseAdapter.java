package com.qsfan.qsfutils.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ==============版权所有===============
 *
 * 类注释:
 * listview的自定义的适配器
 * 抽取框架:
 * 1.发现共性,需要向上抽取
 * 2.抽取过程中,发现未知数据,通过构造传递
 * 3.数据类型,泛型T
 * 4.非共性方法,抽象,让子类处理
 *
 * 作者: QSFan
 * 邮箱: qsfan_vip.163.com
 * 时间: 2017/4/18 16:03
 * 版本:
 * 备注：
 * ==============版权所有===============
*/
public abstract class DefaultBaseAdapter<T> extends BaseAdapter {
    /**
     * 数据源
     */
    public List<T> datas;
    public Context context;

    public DefaultBaseAdapter(List<T> datas , Context context){
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
    
}
