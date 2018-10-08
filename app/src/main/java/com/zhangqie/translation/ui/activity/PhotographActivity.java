package com.zhangqie.translation.ui.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2018/10/8
 * Describe:
 */
public class PhotographActivity extends BaseActivity {

    @BindView(R.id.home_top_name)
    TextView homeTopName;
    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected int initLayout() {
        return R.layout.photogtaph_activity;
    }

    @Override
    protected void initView() {
        homeTopName.setText("拍照翻译");
    }

    @Override
    protected void initBeforeData() {

    }


    @OnClick(R.id.home_tour_close)
    public void onViewClicked() {
        finish();
    }
}
