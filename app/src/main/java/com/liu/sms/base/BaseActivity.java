package com.liu.sms.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by liu on 2016/1/19 0019.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化点击侦听
     */
    public abstract void initListener();

    /**
     * 处理点击事件
     * @param v
     */
    public abstract void processClick(View v);
}
