package com.zhangqie.translation.model;

import android.util.Log;

import com.zhangqie.translation.api.ApiManager;
import com.zhangqie.translation.api.ApiService;
import com.zhangqie.translation.api.SubscriberCallBack;
import com.zhangqie.translation.view.IView;
import com.zhangqie.translation.view.MainContract;

import java.util.Map;

/**
 * Created by zhangqie on 2017/6/26.
 */

public class MainModelImp extends BaseModel<IView.IMvpListener> implements MainContract.DataModle{

    ApiService apiService = ApiManager.getInstance().getStrApiService();

    public MainModelImp(IView.IMvpListener listener){
        attchModel(listener);
    }

    @Override
    public void requestData(Map<String, Object> map) {
        addSubscription(apiService.getTranslationRequest(map), new SubscriberCallBack<String>() {
            @Override
            protected void onSuccess(String result) {
                listener.onDataCallBackListenter(result);
            }

            @Override
            protected void onFailure(String errorMsg) {
                listener.onError(errorMsg);
            }

            @Override
            protected void onFinish() {
                listener.onCompleted();
            }
        });
    }
}
