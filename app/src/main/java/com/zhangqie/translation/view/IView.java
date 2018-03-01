package com.zhangqie.translation.view;

/**
 * Created by zhangqie on 2016/2/26.
 */

public interface IView {


    void onLoadContributorStart();

    void onLoadContribtorComplete(String object);

    void onNetWork();

    void onError(String error);

    interface IMvpListener{

        void onDataCallBackListenter(String string);

        void onError(String error);

        void onCompleted();
    }


}
