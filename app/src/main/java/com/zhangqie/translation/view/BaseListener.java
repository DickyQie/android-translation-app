package com.zhangqie.translation.view;

/**
 * Created by zhangqie on 2016/2/26.
 */

public interface BaseListener<R> {

    void onSuccess(R r);

    void onFailure(String errorMsg);

    void onCompleted();
}
