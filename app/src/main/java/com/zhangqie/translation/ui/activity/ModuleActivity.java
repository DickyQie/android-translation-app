package com.zhangqie.translation.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;
import com.zhangqie.translation.ui.fragment.FragmentFactory;

import butterknife.BindView;

/**
 * Created by zhangqie on 2017/12/26.
 */

public class ModuleActivity extends BaseActivity {

    @BindView(R.id.frame_module)
    FrameLayout frameModule;

    FragmentManager fragmentManager;
    Fragment mCurrentFragment;
    public Intent intent;
    public int resId;


    @Override
    protected int initLayout() {
        return R.layout.module_layout;
    }

    @Override
    protected void initView() {
        intent = getIntent();
        resId = intent.getIntExtra("resId", 0);
        if (intent.getExtras() != null) {
            resId = intent.getExtras().getInt("resId");
        }
    }


    @Override
    protected void initBeforeData() {
        showFragment();
    }

    private void showFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = fragmentManager
                .beginTransaction();
        if (mCurrentFragment != null) {
            mFragmentTransaction.hide(mCurrentFragment);
        }
        mCurrentFragment = FragmentFactory.createById(resId);
        if (mCurrentFragment.isAdded())
        {
            mFragmentTransaction.show(mCurrentFragment);
        }else {
            mFragmentTransaction.add(R.id.frame_module, mCurrentFragment,mCurrentFragment.getClass().getName());
        }
        mFragmentTransaction.commitAllowingStateLoss();
    }

}
