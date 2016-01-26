package com.hy.news;

import com.hy.news.fragment.HomeFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import com.hy.news.fragment.MenuFragment;
import com.hy.news.fragment.NewFragment;
import com.hy.news.fragment.NewFragment2;

/**
 * 1.
 * 2.设置内容文本剩余长度
 * 3.设置滑动方向
 * 4.设置阴影
 */

public class MainActivity extends SlidingFragmentActivity implements MenuFragment.OnSwitchFragmentClickListener{
    SlidingMenu menu;
    NewFragment newFragment;
    NewFragment2 frag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setBehindContentView(R.layout.activity_menu);
        setContentView(R.layout.activity_main);
        init(savedInstanceState);


    }

    /**
     * 初始化数据
     * @param savedInstanceState
     */
    private void init(Bundle savedInstanceState) {
//        //初始化内容页
//        newFragment = new NewFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content, newFragment).commit();
        //初始化菜单
        if (savedInstanceState==null){
            MenuFragment menuFragment = new MenuFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_menu, menuFragment).commit();
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_content,homeFragment).commit();
        }
        menu = getSlidingMenu();
        //设置滑动方向
        menu.setMode(SlidingMenu.LEFT);
        //设置阴影及阴影长度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shawdow);
        //设置内容文本的剩余长度
        menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
//	   menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);//测拉菜单按钮等的焦点被夺走或失效，所以这个属性最好不好设了
        //设置滑动范围
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //设置渐变效果
        menu.setFadeDegree(0.35f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**接口
     * 方法D
     * 回调
     */

    @Override
    public void OnSwitchFragmentClick(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content, fragment).commit();
        //设置切换
        menu.toggle();
    }

    /**
     * 方法D
     * 回调
     */
//    public void showFragment(Fragment com.hy.news.fragment) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content, com.hy.news.fragment).commit();
//        //设置切换
//        menu.toggle();
//    }






    /***
     *
     * 添加，及隐藏，待定...
     * */
//    @Override
//    public void OnSwitchFragmentClick(Fragment com.hy.news.fragment) {
//        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
//        hide(transaction,com.hy.news.fragment);
//        transaction.add(R.id.frag_content, com.hy.news.fragment);
//        transaction.commit();
//
//        //设置切换
//        menu.toggle();
//    }
//    private void hide(FragmentTransaction transaction, Fragment com.hy.news.fragment) {
//        if (newFragment!=null){
//            transaction.hide(newFragment);
//        }
//        int i=com.hy.news.fragment.getArguments().getInt("position");
//        switch (i){
//            case 1:
//                transaction.hide(com.hy.news.fragment);
//                break;
//            case 2:
//                transaction.hide(com.hy.news.fragment);
//                break;
//            case 3:
//                transaction.hide(com.hy.news.fragment);
//                break;
//            case 4:
//                transaction.hide(com.hy.news.fragment);
//                break;
//            case 5:
//                transaction.hide(com.hy.news.fragment);
//                break;
//
//        }
//
//    }



}
