package com.zhangqie.translation.tool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.graphics.drawable.DrawableCompat;

import java.io.File;

/**
 * Created by zhangqie on 2017/3/9.
 */

public class UtilImags {


    /***
     * 图片颜色修改
     * @param context
     * @param image
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Context context,int image, ColorStateList colors) {

        // Drawable drawable1=context.getResources().getDrawable(image);
        Drawable drawable = context.getResources().getDrawable(image);
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

    /***
     * 图片颜色修改
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }


    public static final File showFilr(Context context)
    {
        String cachePath;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath =context.getCacheDir().getPath();
        }
        return new File(cachePath+File.separator+"thumb");
    }















    }
