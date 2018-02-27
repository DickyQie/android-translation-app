package com.zhangqie.translation.ui.activity;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BasenActivity;
import com.zhangqie.translation.presenter.MainPresenter;
import com.zhangqie.translation.view.IView;

/**
 * Created by zhangqie on 2017/12/21.
 */

public class A extends BasenActivity<IView,MainPresenter> implements IView {


    @Override
    protected int setMainLayout() {
        return R.layout.nav_header_main;
    }

    @Override
    protected void initView() {
        p.showVersionAPI();
    }

    @Override
    protected void initBeforeData() {

    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onLoadContributorStart() {

    }

    @Override
    public void onLoadContribtorComplete(Object object) {

    }

    @Override
    public void onNetWork() {

    }

    @Override
    public void onError() {

    }
}
