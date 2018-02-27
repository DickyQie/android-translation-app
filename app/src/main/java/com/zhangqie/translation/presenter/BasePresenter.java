package com.zhangqie.translation.presenter;


import java.lang.ref.WeakReference;

/**
 * Created by zhangqie on 2016/2/26.
 */

public abstract class BasePresenter<T> implements Presenter<T> {

    WeakReference<T> weakReference;

    @Override
    public void attachView(T view) {
        weakReference=new WeakReference<T>(view);
    }
    @Override
    public void detachView() {
        if(weakReference!=null)
        {
            weakReference.clear();
            weakReference=null;
        }
    }

    public T getView() {
        return weakReference.get();
    }

}

