package com.zhangqie.translation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhangqie.translation.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhangqie on 2017/9/13.
 *
 */

public abstract class BasenFragment<V,T extends BasePresenter<V>> extends Fragment {

    protected Unbinder unbinder;
    protected T p;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            p=createPresenter();
            p.attachView((V)this);
            initView();
            initBeforeData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract T createPresenter();

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initBeforeData();

    protected void showToastShort(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    protected void showToastShort(int msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        p.detachView();
        p = null;
    }
}
