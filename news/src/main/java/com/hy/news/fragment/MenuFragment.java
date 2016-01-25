package com.hy.news.fragment;

import java.util.ArrayList;
import java.util.List;

import com.hy.news.R;
import com.makeramen.roundedimageview.RoundedImageView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View mView;
    private ListView mList;
    private RoundedImageView mImageView;
    private List<String> mData = new ArrayList<String>();
    OnSwitchFragmentClickListener OnSwitchFragmentClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            inFlater(inflater, container);
        }
        return mView;
    }

    private void inFlater(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.listview_menu, container, false);
        mImageView = (RoundedImageView) mView.findViewById(R.id.imageView1);
        mList = (ListView) mView.findViewById(R.id.list_view);
        mData.add("新闻");
        mData.add("专题");
        mData.add("动态");
        mData.add("个人中心");
        mData.add("退出");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mData);
        mList.setAdapter(adapter);
        mList.setOnItemClickListener(this);

    }

    //设置点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment = null;
//        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                fragment = new NewFragment();
//                bundle.putString("position", "1");
//                bundle.putInt("position",1);
//                com.hy.news.fragment.setArguments(bundle);

                break;
            case 1:
                fragment = new NewFragment2();
//                bundle.putString("position", "2");
//                bundle.putInt("position",2);
//                com.hy.news.fragment.setArguments(bundle);
                break;
            case 2:
                fragment = new NewFragment3();
//                bundle.putString("position", "3");
//                bundle.putInt("position",3);
//                com.hy.news.fragment.setArguments(bundle);
                break;
            case 3:
                fragment = new NewFragment4();
//                bundle.putString("position", "4");
//                bundle.putInt("position",4);
//                com.hy.news.fragment.setArguments(bundle);
                break;
            case 4:
                fragment = new NewFragment5();
//                bundle.putString("position", "5");
//                bundle.putInt("position",5);
//                com.hy.news.fragment.setArguments(bundle);
                break;
        }

        switchFragment(fragment);
    }

    //设置回调
    public interface OnSwitchFragmentClickListener {
        void OnSwitchFragmentClick(Fragment fragment);
    }

    /**
     * 选择fragment
     * 交给宿主Activity处理，如果它希望处理
     */
    private void switchFragment(Fragment fragment) {
        if (fragment != null) {

            if (getActivity() instanceof OnSwitchFragmentClickListener) {
                ((OnSwitchFragmentClickListener) getActivity()).OnSwitchFragmentClick(fragment);
            }
        }
    }
    //不用接口
//    private void switchFragment(Fragment com.hy.news.fragment){
//        if (com.hy.news.fragment != null) {
//            //不为空，将返回给MainActivity
//            if (getActivity() instanceof MainActivity) {
//                ((MainActivity) getActivity()). showFragment(com.hy.news.fragment);
//            }
//        }
//
//    }

}
