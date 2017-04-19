package com.qsfan.mycompileutils.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qsfan.mycompileutils.R;

public class Test2Activity extends BaseActivity {
    private Button bt_next;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test2);
//    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test2);
        bt_next = getViewById(R.id.bt_next);

    }

    @Override
    protected void setListener() {
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Test2Activity.this, Test3Activity.class));
            }
        });
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

}
