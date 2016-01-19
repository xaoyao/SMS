package com.liu.sms.ui.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

import com.liu.sms.R;
import com.liu.sms.adapter.MainPageAdapter;
import com.liu.sms.base.BaseActivity;
import com.liu.sms.ui.fragment.ConversationFragment;
import com.liu.sms.ui.fragment.GroupFragment;
import com.liu.sms.ui.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private MainPageAdapter adapter;
    private TextView tvTabConversation;
    private TextView tvTabGroup;
    private TextView tvTabSearch;
    private View viewLine;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);


        viewPager= (ViewPager) findViewById(R.id.vp);
        tvTabConversation= (TextView) findViewById(R.id.tv_conversation);
        tvTabGroup= (TextView) findViewById(R.id.tv_group);
        tvTabSearch= (TextView) findViewById(R.id.tv_search);
        viewLine=findViewById(R.id.v_line);


    }

    @Override
    public void initData() {
        fragments=new ArrayList<Fragment>();
        fragments.add(new ConversationFragment());
        fragments.add(new GroupFragment());
        fragments.add(new SearchFragment());
        adapter=new MainPageAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        // 改变选中选项卡文本的颜色和大小
        textChange();
        //设置红线的宽带为屏幕的1/3
        lineWidth();
    }

    @Override
    public void initListener() {

        //ViewPage切换侦听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //红线位移的距离
                int distance=positionOffsetPixels/3;
                //红线移动动画
                //移动时position为上一个fragment的值
                viewLine.animate().translationX(distance+position*viewLine.getWidth()).setDuration(0);

            }

            @Override
            public void onPageSelected(int position) {
                textChange();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void processClick(View v) {

    }

    /**
     * 改变选中选项卡文本的颜色和大小
     */
    private void textChange(){
        int item=viewPager.getCurrentItem();
        //改变选中选项卡文字的颜色
        tvTabConversation.setTextColor(item==0? Color.RED:Color.WHITE);
        tvTabGroup.setTextColor(item==1?Color.RED:Color.WHITE);
        tvTabSearch.setTextColor(item==2?Color.RED:Color.WHITE);
        //改变选中选项卡文字的大小
        tvTabConversation.animate().scaleX(item == 0 ? 1.2f : 1f).setDuration(200);
        tvTabGroup.animate().scaleX(item == 1 ? 1.2f : 1f).setDuration(200);
        tvTabSearch.animate().scaleX(item == 2 ? 1.2f : 1f).setDuration(200);
        tvTabConversation.animate().scaleY(item == 0 ? 1.2f : 1f).setDuration(200);
        tvTabGroup.animate().scaleY(item == 1 ? 1.2f : 1f).setDuration(200);
        tvTabSearch.animate().scaleY(item == 2 ? 1.2f : 1f).setDuration(200);

    }

    /**
     * 设置红线的宽带为屏幕的1/3
     */
    private void lineWidth(){
        int width=getWindowManager().getDefaultDisplay().getWidth();
        viewLine.getLayoutParams().width=width/3;
    }
}
