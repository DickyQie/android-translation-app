package com.zhangqie.translation.ui;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.zhangqie.translation.R;
import com.zhangqie.translation.base.BaseActivity;
import com.zhangqie.translation.ui.activity.A;
import com.zhangqie.translation.ui.activity.AboutActivity;
import com.zhangqie.translation.ui.fragment.HomeFragment;

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

    @Override
    protected int initLayout() {
        return R.layout.home_main;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    protected void initBeforeData() {
        fragmentManager = getSupportFragmentManager();
        fragmentArrayList.add(new HomeFragment());
        showFragment(0);
    }

    private void showFragment(int page) {
        FragmentTransaction mFragmentTransaction = fragmentManager
                .beginTransaction();
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
            return true;
        }
        if (id == R.id.action_photo) {
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
            // Handle the camera action
        }  else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(HomeActivity.this, A.class);
            startActivity(intent);
        } else if (id == R.id.nav_photo) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
        }

        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    setResult(1);
                    finish();
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
