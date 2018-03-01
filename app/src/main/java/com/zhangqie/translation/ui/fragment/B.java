package com.zhangqie.translation.ui.fragment;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BasenFragment;
import com.zhangqie.translation.presenter.MainPresenter;
import com.zhangqie.translation.view.IView;

/**
 * Created by Administrator on 2018/2/28.
 */

public class B extends BasenFragment<IView,MainPresenter> implements IView {


    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initBeforeData() {

    }

    @Override
    public void onLoadContributorStart() {

    }

    @Override
    public void onLoadContribtorComplete(String object) {

    }

    @Override
    public void onNetWork() {

    }

    @Override
    public void onError(String error) {

    }
}
