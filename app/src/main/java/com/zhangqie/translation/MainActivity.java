package com.zhangqie.translation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.translation.ui.HomeActivity;

public class MainActivity extends AppCompatActivity{


    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, HomeActivity.class);
                startActivityForResult(intent,1);
            }
        };
        handler.postDelayed(runnable,1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == 1){
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        handler = null;
        super.onDestroy();
    }
}
