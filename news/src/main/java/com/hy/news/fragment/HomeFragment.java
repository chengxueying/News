package com.hy.news.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hy.news.R;
import com.hy.news.base.BaseFragment;

/**
 * Created by Administrator on 2016/1/25.
 */
public class HomeFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater) {
       View view=inflater.inflate(R.layout.fragment_home,null);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
