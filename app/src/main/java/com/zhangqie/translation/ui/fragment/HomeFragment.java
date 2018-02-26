package com.zhangqie.translation.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseFragment;
import com.zhangqie.translation.ui.activity.NewsContentActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2018/2/24.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.trabslation_edittext)
    EditText trabslationEdittext;
    @BindView(R.id.tranls_result)
    TextView tranlsResult;
    @BindView(R.id.news_time)
    TextView newsTime;


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


    @OnClick({R.id.tranl_full_screen, R.id.tranl_replication, R.id.tranl_sound,R.id.newslayout_click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tranl_full_screen:
                break;
            case R.id.tranl_replication:
                break;
            case R.id.tranl_sound:
                break;
            case R.id.newslayout_click:
                Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                startActivity(intent);
                break;
        }
    }
}
