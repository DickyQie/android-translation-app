package com.zhangqie.translation.ui.fragment;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseFragment;
import com.zhangqie.translation.ui.activity.ModuleActivity;
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
    @BindView(R.id.home_forword)
    LinearLayout homeForword;


    @Override
    protected int initLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        trabslationEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    homeForword.setVisibility(View.VISIBLE);
                }else {
                    homeForword.setVisibility(View.GONE);
                }
            }
        });

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
                Intent intentb = new Intent(getActivity(), ModuleActivity.class);
                intentb.putExtra("resId",R.id.tranl_replication);
                startActivity(intentb);
                break;
            case R.id.newslayout_click:
                Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                startActivity(intent);
                break;
        }
    }
}
