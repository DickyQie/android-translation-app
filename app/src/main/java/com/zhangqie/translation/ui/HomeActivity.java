package com.zhangqie.translation.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;
import com.zhangqie.translation.entity.PhotographInfo;
import com.zhangqie.translation.tool.FileUtil;
import com.zhangqie.translation.tool.RecognizeService;
import com.zhangqie.translation.tool.UtilDB;
import com.zhangqie.translation.ui.activity.A;
import com.zhangqie.translation.ui.activity.AboutActivity;
import com.zhangqie.translation.ui.activity.ModuleActivity;
import com.zhangqie.translation.ui.activity.PhotographActivity;
import com.zhangqie.translation.ui.fragment.B;
import com.zhangqie.translation.ui.fragment.HomeFragment;
import com.zhangqie.translation.ui.fragment.SoundFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by zhangqie on 2017/9/13.
 *
 */

public class HomeActivity  extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private Fragment mCurrentFragment;

    private FragmentManager fragmentManager;

    private long mExitTime;
    private final int INTERVAL = 2000;
    private static final int REQUEST_CODE_GENERAL_BASIC = 106;

    private boolean hasGotToken = false;
    private HomeFragment homeFragment;


    @Override
    protected int initLayout() {
        return R.layout.home_main;
    }

    @Override
    protected void initView() {
        try {
            toolbar.setTitle("指上翻译");
            setSupportActionBar(toolbar);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            navigationView.setNavigationItemSelectedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void initBeforeData() {
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        fragmentArrayList.add(homeFragment);
        fragmentArrayList.add(new SoundFragment());
        showFragment(0,1);


        initAccessTokenWithAkSk();
        //initAccessTokenLicenseFile();
    }

    private void showFragment(int page,int index) {
        try {
            FragmentTransaction mFragmentTransaction = fragmentManager
                    .beginTransaction();
           /* if (index == 0){
                mFragmentTransaction.remove(homeFragment);
            }*/
            if (mCurrentFragment != null) {
                mFragmentTransaction.hide(mCurrentFragment);
            }
            mCurrentFragment = fragmentArrayList.get(page);
            if (mCurrentFragment.isAdded())
            {
                mFragmentTransaction.show(mCurrentFragment);
            }else {
                mFragmentTransaction.add(R.id.fragment, mCurrentFragment,mCurrentFragment.getClass().getName());
            }
            mFragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sound) {
          /*  Intent intentb = new Intent(HomeActivity.this, ModuleActivity.class);
            intentb.putExtra("resId",R.id.tranl_replication);
            startActivity(intentb);*/
            toolbar.setTitle("语音翻译");
            showFragment(1,1);
            return true;
        }
        if (id == R.id.action_photo) {
            toolbar.setTitle("拍照翻译");
            Intent intent = new Intent(this, CameraActivity.class);
            intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                    FileUtil.getSaveFile(getApplication()).getAbsolutePath());
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                    CameraActivity.CONTENT_TYPE_GENERAL);
            startActivityForResult(intent, REQUEST_CODE_GENERAL_BASIC);
            return true;
        }
        if (id == R.id.action_settings){
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            toolbar.setTitle("指上翻译");
            showFragment(0,1);
            drawer.closeDrawer(GravityCompat.START);
        }else if (id == R.id.nav_sound) {
            toolbar.setTitle("语音翻译");
            showFragment(1,1);
            drawer.closeDrawer(GravityCompat.START);
        }else if (id == R.id.nav_photo) {
            toolbar.setTitle("拍照翻译");
        }else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(HomeActivity.this, A.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                showToastShort("识别失败");
            }
        }, getApplicationContext(),  "Y9WlhjkaO09H5pmNLHqWvisy", "t8yurhigVRimcHGw1iej3jxao973M1G4");
    }

    /**
     * 自定义license的文件路径和文件名称，以license文件方式初始化
     */
    private void initAccessTokenLicenseFile() {
        OCR.getInstance(this).initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                showToastShort("识别失败");
            }
        }, "aip.license", getApplicationContext());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 识别成功回调，通用文字识别
        if (requestCode == REQUEST_CODE_GENERAL_BASIC && resultCode == Activity.RESULT_OK) {
            RecognizeService.recGeneralBasic(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                          // showToastShort(result);
                          /* Bundle bundle = new Bundle();
                           bundle.putString("result","123");
                           homeFragment.setArguments(bundle);*/
                          /* UtilDB.ADDSHAREDDATA("result",result);*/
                           //showFragment(0,0);

                            Intent intent = new Intent(HomeActivity.this, PhotographActivity.class);
                            intent.putExtra("reselt",result);
                            startActivity(intent);
                        }
                    });
        }
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    if (System.currentTimeMillis() - mExitTime > INTERVAL) {
                        showToastShort("再按一次退出程序");
                        mExitTime = System.currentTimeMillis();
                    } else {
                        setResult(1);
                        finish();
                    }
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
