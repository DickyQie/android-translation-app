package com.zhangqie.translation.ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseFragment;
import com.zhangqie.translation.base.BasenFragment;
import com.zhangqie.translation.presenter.MainPresenter;
import com.zhangqie.translation.view.IView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/12/26.
 */


public class SoundFragment extends BasenFragment<IView,MainPresenter> implements IView{

    @BindView(R.id.home_top_name)
    TextView publicTopTitle;
    @BindView(R.id.trabslation_edittext)
    EditText trabslationEdittext;
    @BindView(R.id.sound_forword)
    LinearLayout soundForword;
    @BindView(R.id.sound_model)
    LinearLayout soundModel;

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.sound_layout;
    }

    @Override
    protected void initView() {
        publicTopTitle.setText(R.string.action_sound);
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

    @OnClick({R.id.home_tour_close,R.id.tranl_full_screen, R.id.tranl_replication, R.id.tranl_sound})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_tour_close:
                getActivity().finish();
                break;
            case R.id.tranl_full_screen:
                break;
            case R.id.tranl_replication:
                break;
            case R.id.tranl_sound:
                break;
        }
    }
}
