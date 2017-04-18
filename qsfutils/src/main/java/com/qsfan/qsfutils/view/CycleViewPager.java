package com.qsfan.qsfutils.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CycleViewPager extends ViewPager {

    public CycleViewPager(Context context) {
        super(context);
    }

    // banner 轮播图
    public CycleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        // 先修正 OnPageChangeListener
        MyPagerChangeListener myPagerChangeListener = new MyPagerChangeListener(
                listener);

        super.setOnPageChangeListener(myPagerChangeListener);
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            setCurrentItem(getCurrentItem() + 1);
            //再次发送消息
            handler.sendEmptyMessageDelayed(2, 2000);
        }

        ;
    };

    public void startSocll() {

        handler.sendEmptyMessageDelayed(1, 2000);

    }

    public class MyPagerChangeListener implements OnPageChangeListener {

        private OnPageChangeListener listener;
        private int position;

        public MyPagerChangeListener(OnPageChangeListener listener) {
            this.listener = listener;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            listener.onPageScrolled(position, positionOffset,
                    positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            this.position = position;
            listener.onPageSelected(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            // ViewPager.SCROLL_STATE_IDLE
            if (state == ViewPager.SCROLL_STATE_IDLE) { // 手指抬起
                // 悄悄的切换
                if (position == CycleViewPager.this.getAdapter().getCount() - 1) {
                    CycleViewPager.this.setCurrentItem(1, false);// 悄悄的切换
                } else if (position == 0) {
                    CycleViewPager.this.setCurrentItem(CycleViewPager.this
                            .getAdapter().getCount() - 2, false);// 悄悄的切换
                }
            }
            listener.onPageScrollStateChanged(state);
        }

    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        // 修正adapter
        InnerAdapter innerAdapter = new InnerAdapter(adapter);
        setOnPageChangeListener(listener);
        super.setAdapter(innerAdapter);
        setCurrentItem(1);
    }

    private OnPageChangeListener listener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class InnerAdapter extends PagerAdapter {

        private PagerAdapter adapter;

        public InnerAdapter(PagerAdapter adapter) {
            this.adapter = adapter;
        }

        @Override
        public int getCount() {
            return adapter.getCount() + 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return adapter.isViewFromObject(view, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 修正position
            if (position == getCount() - 1) {
                position = 0;
            } else if (position == 0) {
                position = adapter.getCount() - 1;
            } else {
                position -= 1;
            }

            return adapter.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            adapter.destroyItem(container, position, object);
        }
    }

}
