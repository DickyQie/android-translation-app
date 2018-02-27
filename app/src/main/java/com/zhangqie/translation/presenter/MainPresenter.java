package com.zhangqie.translation.presenter;

import android.util.Log;

import com.zhangqie.translation.view.IView;

import java.util.HashMap;
import java.util.Map;

import com.zhangqie.translation.model.MainModelImp;

/**
 * Created by zhangqie on 2017/11/26.
 */

public class MainPresenter extends BasePresenter<IView> implements IView.IMvpListener{

    private MainModelImp mainModelImp;



    public MainPresenter(){
        mainModelImp = new MainModelImp(this);
    }

    public void showVersionAPI() {
        Map<String,Object> map = new HashMap<>();
        //map.put("a","苏州市");
        //map.put("ip","63.223.108.42");
        //map.put("tel","15850781443");
        //location=%E7%BB%A5%E5%BE%B7&output=json&ak=11ffd27d38deda622f51c9d314d46b17
        map.put("location","绥德");
        map.put("output","json");
        map.put("ak","11ffd27d38deda622f51c9d314d46b17");
        mainModelImp.requestData(map);
    }

    @Override
    public void onDataCallBackListenter(String string) {
        Log.i("onDataCallBackLi",string);
        final IView iView = getView();
        iView.onLoadContribtorComplete(string);
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onCompleted() {

    }
}
