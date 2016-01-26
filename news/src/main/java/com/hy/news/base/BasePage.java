package com.hy.news.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by xy on 2016/1/26.
 */
public abstract class BasePage {
    /**
     * 画界面
     * 初始化数据
     * */
    private View rootView;
    public Context mContext;
    public BasePage(Context ctx) {
        this.mContext=ctx;
        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        rootView= initView(inflater);

    }
    public View getRootView(){
        return rootView;
    }

    public abstract View initView(LayoutInflater inflater);
    public abstract void initData();

}
