package com.zhangqie.translation.api;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by zhangqie on 2017/11/15.
 */

public class PubcApplication extends Application {

    public static SharedPreferences preferences;

    public static SharedPreferences.Editor editor;

    @Override
    public void onCreate()
    {
        super.onCreate();
        preferences = getSharedPreferences("scbdata", MODE_PRIVATE);
        editor = preferences.edit();
    }


}
