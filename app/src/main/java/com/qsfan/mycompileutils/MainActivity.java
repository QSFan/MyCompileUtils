package com.qsfan.mycompileutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qsfan.qsfutils.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtil.showTextToast(this,"haha");
    }
}
