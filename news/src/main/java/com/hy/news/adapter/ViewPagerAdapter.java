package com.hy.news.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.hy.news.base.BasePage;
import com.hy.news.view.LazyViewPager;

import java.util.List;

/**
 * Created by Administrator on 2016/1/26.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context ctx;
    private List<BasePage> list;

    public ViewPagerAdapter(Context ctx, List<BasePage> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view1, Object view2) {
        return view1 == view2;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((LazyViewPager) container).removeView(list.get(position).getRootView());
//            super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((LazyViewPager) container).addView(list.get(position).getRootView(), 0);
        return list.get(position).getRootView();
    }
}
