package com.zhangqie.translation.view;

/**
 * Created by zhangqie on 2016/2/26.
 */

public interface BaseView<T> {

    void onSuccess(T result);

    void onFailure(String errorMsg);

    void showLoading();

    void hideLoading();

}
