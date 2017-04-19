package com.qsfan.mycompileutils.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qsfan.mycompileutils.R;

public class ActivityBGAtest1 extends BaseActivity {
private Button bt_next;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_activity_bgatest1);
        bt_next = getViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityBGAtest1.this, Test2Activity.class));
            }
        });
        /**
         * 设置滑动返回是否可用
         */
        mSwipeBackHelper.setSwipeBackEnable(true);
        /**
         * 设置是否是微信滑动返回样式
         */
        mSwipeBackHelper.setIsWeChatStyle(true);
        /**
         * 设置是否显示滑动返回的阴影效果
         */
        mSwipeBackHelper.setIsNeedShowShadow(true);
        /**
         * 设置阴影区域的透明度是否根据滑动的距离渐变
         */
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    /**
     * 测试滑动返回相关接口
     */
//    private void testSwipeBackLayout() {
//        // 测试动态设置滑动返回是否可用
//        mSwipeBackEnableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean swipeBackEnable) {
//                /**
//                 * 设置滑动返回是否可用
//                 */
//                mSwipeBackHelper.setSwipeBackEnable(swipeBackEnable);
//            }
//        });
//
//        // 测试动态设置是否仅仅跟踪左侧边缘的滑动返回
//        ((SwitchCompat) getViewById(R.id.onlyTrackingLeftEdgeSwitch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isOnlyTrackingLeftEdge) {
//                /**
//                 * 设置是否仅仅跟踪左侧边缘的滑动返回
//                 */
//                mSwipeBackHelper.setIsOnlyTrackingLeftEdge(isOnlyTrackingLeftEdge);
//            }
//        });
//
//        // 测试动态设置是否是微信滑动返回样式
//        ((SwitchCompat) getViewById(R.id.weChatStyleSwitch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isWeChatStyle) {
//                /**
//                 * 设置是否是微信滑动返回样式
//                 */
//                mSwipeBackHelper.setIsWeChatStyle(isWeChatStyle);
//            }
//        });
//
//        // 测试动态设置是否显示滑动返回的阴影效果
//        ((SwitchCompat) getViewById(R.id.needShowShadowSwitch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isNeedShowShadow) {
//                /**
//                 * 设置是否显示滑动返回的阴影效果
//                 */
//                mSwipeBackHelper.setIsNeedShowShadow(isNeedShowShadow);
//            }
//        });
//
//        // 测试动态设置阴影区域的透明度是否根据滑动的距离渐变
//        ((SwitchCompat) getViewById(R.id.shadowAlphaGradientSwitch)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isShadowAlphaGradient) {
//                /**
//                 * 设置阴影区域的透明度是否根据滑动的距离渐变
//                 */
//                mSwipeBackHelper.setIsShadowAlphaGradient(isShadowAlphaGradient);
//            }
//        });
//    }
}
