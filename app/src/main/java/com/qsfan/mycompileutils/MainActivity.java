package com.qsfan.mycompileutils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qsfan.mycompileutils.activity.ActivityBGAtest1;
import com.qsfan.mycompileutils.activity.BaseActivity;
import com.qsfan.qsfutils.utils.PublicUtils;

public class MainActivity extends BaseActivity {

    private TextView tv_cehuan;
    private Button bt_get_v;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//
//    }

    /**
     * 主界面不需要支持滑动返回，重写该方法永久禁用当前界面的滑动返回功能
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    private void initView() {
        tv_cehuan = (TextView) findViewById(R.id.tv_cehuan);
        bt_get_v = (Button) findViewById(R.id.bt_get_v);
        tv_cehuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityBGAtest1.class));
            }
        });
        bt_get_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublicUtils.downTime(bt_get_v, "获取验证码");
            }
        });
    }
}
