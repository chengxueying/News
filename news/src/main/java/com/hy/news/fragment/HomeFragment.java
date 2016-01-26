package com.hy.news.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.RadioGroup;

import com.hy.news.R;
import com.hy.news.adapter.ViewPagerAdapter;
import com.hy.news.base.BaseFragment;
import com.hy.news.base.BasePage;
import com.hy.news.home.FunctionPage;
import com.hy.news.home.GovAffairsPage;
import com.hy.news.home.InServicePage;
import com.hy.news.home.NewsCenterPage;
import com.hy.news.home.SettingPage;
import com.hy.news.view.LazyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xy on 2016/1/25.
 */
public class HomeFragment extends BaseFragment {
    public LazyViewPager lazyViewPager;
    public RadioGroup main_radio;

    @Override
    protected View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        lazyViewPager = (LazyViewPager) view.findViewById(R.id.viewPage);
        main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
        return view;
    }

    List<BasePage> list = new ArrayList();

    @Override
    public void initData(Bundle savedInstanceState) {
        list.add(new FunctionPage(mContext));//mContext来自BaseFragment
        list.add(new NewsCenterPage(mContext));
        list.add(new InServicePage(mContext));
        list.add(new GovAffairsPage(mContext));
        list.add(new SettingPage(mContext));
        lazyViewPager.setAdapter(new ViewPagerAdapter(mContext, list));
        main_radio.setOnCheckedChangeListener(new MyOnCheckedListener());
        lazyViewPager.setOnPageChangeListener(new LazyViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyOnCheckedListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_function:
                    lazyViewPager.setCurrentItem(0, false);
                    break;
                case R.id.rb_news_center:
                    lazyViewPager.setCurrentItem(1, false);
                    break;
                case R.id.rb_intelligence_service:
                    lazyViewPager.setCurrentItem(2, false);
                    break;
                case R.id.rb_government_guide:
                    lazyViewPager.setCurrentItem(3, false);
                    break;
                case R.id.rb_settings:
                    lazyViewPager.setCurrentItem(4, false);
                    break;
            }

        }
    }

}
