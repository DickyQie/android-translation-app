package com.zhangqie.translation.ui.activity;

import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2018/2/28.
 */

public class FullScreenActivity extends BaseActivity {


    @BindView(R.id.fs_size_text)
    TextView fsSizeText;

    @Override
    protected int initLayout() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.fullscreen_layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initBeforeData() {
        String data = getIntent().getStringExtra("fulldata");
        fsSizeText.setText(data);
    }

    @OnClick({R.id.fs_img_nof})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fs_img_nof:
                finish();
                break;
        }
    }



}
