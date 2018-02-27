package com.zhangqie.translation.api;


public final class ApiException extends RuntimeException {

    private final String msg;

    public ApiException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
