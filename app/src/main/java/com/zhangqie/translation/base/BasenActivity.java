package com.zhangqie.translation.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhangqie.translation.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhangqie on 2017/2/25.
 */

public abstract class BasenActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected Unbinder unbinder;
    protected T p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(setMainLayout());
        unbinder = ButterKnife.bind(this);
        p=createPresenter();
        p.attachView((V)this);
        initView();
        initBeforeData();
    }

    public abstract T createPresenter();
    /**
     * 初始化布局
     */
    protected abstract int setMainLayout();

    /**
     * 初始化先前数据
     */
    protected abstract void initBeforeData();

    /**
     * 初始化事件
     */
    protected abstract void initView();

    /**
     * 弹出toast 显示时长short
     *
     * @param msg
     */
    protected void showToastShort(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    protected void showToastShort(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    /**
     * 弹出toast 显示时长long
     *
     * @param msg
     */
    protected void showToastLong(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }



    /***
     * 跳转Activity
     * @param mClass
     */
    protected void openActivity(Class<?> mClass) {
        openIntent(new Intent(this, mClass));
    }

    protected void openIntent(Intent intent) {
        startActivity(intent);
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
        }
        p.detachView();
        p=null;
    }



}

