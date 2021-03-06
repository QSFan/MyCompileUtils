package com.qsfan.mycompileutils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qsfan.mycompileutils.activity.ActivityBGAtest1;
import com.qsfan.mycompileutils.activity.BaseActivity;
import com.qsfan.mycompileutils.address.picker.AddressInitTask;
import com.qsfan.qsfutils.utils.PublicUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_cehuan;
    private Button bt_get_v;
    private LinearLayout ll_add_permission;
    private Button bt_address;

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
        ll_add_permission = (LinearLayout) findViewById(R.id.ll_add_permission);
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

        ll_add_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bt_address = (Button) findViewById(R.id.bt_address);
        bt_address.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_address:
                AddressInitTask addressInitTask = new AddressInitTask(this);
                addressInitTask.execute("河南", "郑州", "二七区");
                addressInitTask.setOnAddressListener(new AddressInitTask.OnAddressListener() {
                    @Override
                    public void onAdressListener(String sheng, String shi, String qu, String shiID, String xianID) {
                   bt_address.setText(sheng+"  "+shi+"  "+qu);
//                        ToastUtil.showToastInThread(getActivity(), "市ID：" + shiID + "\n县ID:" + xianID);

                    }
                });
                break;
        }
    }
}
