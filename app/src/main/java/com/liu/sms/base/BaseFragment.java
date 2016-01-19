package com.liu.sms.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liu on 2016/1/19 0019.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(inflater,container,savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initListener();
    }

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    /**
     * 初始化Fragment
     */
    public abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
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
