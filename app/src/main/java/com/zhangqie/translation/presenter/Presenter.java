package com.zhangqie.translation.presenter;


/**
 * Created by zhangqie on 2016/2/26.
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView();
}
