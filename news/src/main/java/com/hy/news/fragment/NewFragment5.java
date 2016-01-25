package com.hy.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/18.
 */
public class NewFragment5 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View com.hy.news.view=inflater.inflate(R.layout.newfragment2,container,false);
        TextView textView=new TextView(getActivity());
        textView.setText("第五个");
        return textView;
    }
}
