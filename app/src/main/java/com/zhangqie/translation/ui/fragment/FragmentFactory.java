package com.zhangqie.translation.ui.fragment;

import android.support.v4.app.Fragment;

import com.zhangqie.translation.R;

/**
 * Created by zhangqie on 2017/12/26.
 */


public class FragmentFactory {

    /**
     * 根据资源id返回不同的fragment
     */
    public static Fragment createById(int resId) {
        Fragment fragment = null;
        switch (resId) {
            case R.id.tranl_replication:// 运营中心
                fragment = new SoundFragment();
                break;

        }
        return fragment;
    }

}
