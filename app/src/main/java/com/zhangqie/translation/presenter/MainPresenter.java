package com.zhangqie.translation.presenter;

import android.content.Context;
import android.util.Log;

import com.zhangqie.translation.tool.NetUtils;
import com.zhangqie.translation.tool.UtilTools;
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
        /*
        map.put("location","绥德");
        map.put("output","json");
        map.put("ak","11ffd27d38deda622f51c9d314d46b17");*/

        String sign = "20180226000127310apple1435660288K7vuNn2OfyYilpevb29x";
        map.put("q","apple");
        map.put("from","auto");
        map.put("to","zh");
        map.put("appid","20180226000127310");
        map.put("salt","1435660288");
        //appid=2015063000000001+q=apple+salt=1435660288+密钥=12345678
        map.put("sign", UtilTools.stringToMD5(sign));

        mainModelImp.requestData(map);
    }

    public void requestShowTranlsData(Context context,Map<String, Object> map){
       /* if (!NetUtils.isNetworkAvailable(context)){
            IView iView = getView();
            iView.onNetWork();
            return;
        }*/
        mainModelImp.requestData(map);
    }


    @Override
    public void onDataCallBackListenter(String string) {
        Log.i("onDataCallBackLi",string);
        IView iView = getView();
        iView.onLoadContribtorComplete(string);
    }

    @Override
    public void onError(String error) {
        IView iView = getView();
        iView.onError(error);
    }

    @Override
    public void onCompleted() {

    }
}
