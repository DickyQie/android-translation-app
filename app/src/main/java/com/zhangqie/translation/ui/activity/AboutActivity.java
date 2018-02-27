package com.zhangqie.translation.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/7/13.
 */

public class AboutActivity extends BaseActivity{

    @BindView(R.id.home_top_name)
    TextView publicTopTitle;

    @Override
    protected int initLayout() {
        return R.layout.about_activity;
    }
    @Override
    protected void initView() {
        publicTopTitle.setText(R.string.action_settings);
    }
    @Override
    protected void initBeforeData() {
    }

    @OnClick({R.id.home_tour_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_tour_close:
                finish();
                break;
        }
    }

}
