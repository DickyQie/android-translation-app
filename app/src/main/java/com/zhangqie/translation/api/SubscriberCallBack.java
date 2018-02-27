package com.zhangqie.translation.api;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;


public abstract class SubscriberCallBack<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {

        String msg;
        //自定义异常(即未请求到数据)
        if(e instanceof ApiException){
            ApiException apiException = (ApiException) e;
            msg = apiException.getMsg();
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            if(code == 503){
                msg = "服务器维护中";
            } else if(code == 500){
                msg = "服务器内部错误";
            } else if (code == 404) {
                msg = "请求地址错误";
            } else{
                msg = "网络不给力";
            }
        } else if (e instanceof RuntimeException){
            msg = "很抱歉，程序运行出错了！";
        } else if (e instanceof SocketTimeoutException){
            msg = "服务器连接超时，请稍后重试！";
        } else if (e instanceof SocketException){
            msg = "服务器连接失败，请检查网络状态！";
        } else if (e instanceof IOException){
            msg = "联网失败，请检查网络状态！";
        } else{
            msg = "未知错误";
        }
        onFailure(msg);
        onFinish();
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        if(t != null){
            onSuccess(t);
        }else{
            onFailure("网络请求失败了!");
        }
    }

    protected abstract void onSuccess(T result);

    protected abstract void onFailure(String errorMsg);

    protected abstract void onFinish();
}
