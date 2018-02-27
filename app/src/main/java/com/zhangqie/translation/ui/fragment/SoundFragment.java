package com.zhangqie.translation.ui.fragment;

import android.view.View;
import android.widget.EditText;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/12/26.
 */


public class SoundFragment extends BaseFragment {


    @BindView(R.id.trabslation_edittext)
    EditText trabslationEdittext;


    @Override
    protected int initLayout() {
        return R.layout.sound_layout;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initBeforeData() {

    }


    @OnClick({R.id.tranl_full_screen, R.id.tranl_replication, R.id.tranl_sound})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tranl_full_screen:
                break;
            case R.id.tranl_replication:
                break;
            case R.id.tranl_sound:
                break;
        }
    }
}
