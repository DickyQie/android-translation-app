package com.zhangqie.translation.ui.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhangqie.translation.R;
import com.zhangqie.translation.api.Api;
import com.zhangqie.translation.base.BaseFragment;
import com.zhangqie.translation.base.BasenFragment;
import com.zhangqie.translation.entity.TranlsInfo;
import com.zhangqie.translation.presenter.MainPresenter;
import com.zhangqie.translation.tool.UtilDB;
import com.zhangqie.translation.ui.activity.FullScreenActivity;
import com.zhangqie.translation.ui.activity.ModuleActivity;
import com.zhangqie.translation.ui.activity.NewsContentActivity;
import com.zhangqie.translation.ui.adapter.MyAdapter;
import com.zhangqie.translation.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2018/2/24.
 */

public class HomeFragment extends BasenFragment<IView,MainPresenter> implements IView {

    @BindView(R.id.trabslation_edittext)
    EditText trabslationEdittext;
    @BindView(R.id.tranls_result)
    TextView tranlsResult;
    @BindView(R.id.news_time)
    TextView newsTime;
    @BindView(R.id.home_forword)
    LinearLayout homeForword;
    @BindView(R.id.spinner)
    Spinner spinner;

    private static final String TRANSLACTION_TYPE = "translaction_type";
    private String[] languageen;
    private String[] languagezh;
    @Override
    protected int initLayout() {
        return R.layout.fragment_main;
    }


    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
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
       languagezh = getResources().getStringArray(R.array.transl_type_zh);
       languageen = getResources().getStringArray(R.array.transl_type_en);
    }

    @Override
    protected void initBeforeData() {
        MyAdapter myAdapter =new MyAdapter(getContext(),languagezh);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                UtilDB.ADDSHAREDDATA(TRANSLACTION_TYPE,languageen[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onLoadContributorStart() {

    }

    @Override
    public void onLoadContribtorComplete(String object) {
        try {
            TranlsInfo tranlsInfo = JSON.parseObject(object,TranlsInfo.class);
            if (tranlsInfo != null) {
                tranlsResult.setText(tranlsInfo.getTrans_result().get(0).getDst());
            }
        } catch (Exception e) {
           tranlsResult.setText(object);
        }
    }

    @Override
    public void onNetWork() {
        showToastShort(R.string.no_network);
    }

    @Override
    public void onError(String error) {
        showToastShort(error);
    }


    @OnClick({R.id.tranl_full_screen, R.id.tranl_replication, R.id.tranl_sound,R.id.newslayout_click,R.id.home_forword})
    public void onClick(View view) {
        String tranData = tranlsResult.getText().toString();
        switch (view.getId()) {
            case R.id.tranl_full_screen:
                if (!TextUtils.isEmpty(tranData)) {
                    Intent intentFull = new Intent(getActivity(), FullScreenActivity.class);
                    intentFull.putExtra("fulldata", tranData);
                    startActivity(intentFull);
                }
                break;
            case R.id.tranl_replication:
                if (!TextUtils.isEmpty(tranData)) {
                    ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData myClip = ClipData.newPlainText("text", tranData);
                    cm.setPrimaryClip(myClip);
                    showToastShort("复制成功，可以粘贴使用了");
                }
                break;
            case R.id.tranl_sound:


                break;
            case R.id.newslayout_click:
                Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                startActivity(intent);
                break;
            case R.id.home_forword:
                try {
                    String data = trabslationEdittext.getText().toString();
                    if (TextUtils.isEmpty(data)){
                        showToastShort("请输入内容");
                        return;
                    }else {
                        p.requestShowTranlsData(getActivity(), Api.showTranslation(data,UtilDB.SELECTSHAREDDATA(TRANSLACTION_TYPE)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
