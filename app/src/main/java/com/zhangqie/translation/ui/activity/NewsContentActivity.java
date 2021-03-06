package com.zhangqie.translation.ui.activity;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhangqie on 2017/11/21.
 */

public class NewsContentActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.home_top_name)
    TextView publicTopTitle;

    String urls="http://wx.weather.com.cn/mtqxw/index_w.shtml";
    boolean isBack=false;
    @Override
    protected int initLayout() {
        return R.layout.newscontent_layout;
    }

    @Override
    protected void initView() {
        publicTopTitle.setText("歆语资讯");
        webview.loadUrl(urls);
    }

    @Override
    protected void initBeforeData() {
        webview.setHorizontalScrollBarEnabled(false);
        webview.setVerticalScrollBarEnabled(false);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.supportMultipleWindows();
        webSettings.setAppCacheMaxSize(1024 * 1024 * 25);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setSavePassword(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSaveFormData(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        try {
            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    if(url.toLowerCase().startsWith("http://") || url.toLowerCase().startsWith("https://"))
                    {
                        return false;
                    }
                    return true;
                }
                @Override
                public void onPageFinished(WebView view, String url) {
                    if (url.indexOf(urls)!=-1) {
                        isBack=true;
                    }else {
                        isBack=false;
                    }
                }
                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    super.onReceivedError(view, errorCode, description, failingUrl);
                }
            });
        } catch (Exception e) {
            return;
        }
    }

    @OnClick({R.id.home_tour_close})
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.home_tour_close:
               if (isBack){
                   finish();
               }else {
                   webview.goBack();
               }
               break;
       }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                if (isBack){
                    finish();
                }else {
                    webview.goBack();
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }


}
