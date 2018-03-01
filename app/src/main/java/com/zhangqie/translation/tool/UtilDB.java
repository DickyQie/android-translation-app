package com.zhangqie.translation.tool;

import android.content.SharedPreferences;

import com.zhangqie.translation.api.PubcApplication;

/**
 * Created by zhangqie on 2017/12/28.
 */

public class UtilDB
{
    public static SharedPreferences sharedPreferences = PubcApplication.preferences;
    public static SharedPreferences.Editor editor = PubcApplication.editor;


    /****
     * 永久缓存
     * @param key
     * @param content
     */
    public static final void ADDSHAREDDATA(String key,String content)
    {
        editor.putString(key,content);
        editor.commit();
    }
    /***
     * 清空
     * @param key
     */
    public static final void DELETESHAREDDATA(String key)
    {
        editor.remove(key);
        editor.commit();
    }
    /***
     * 查询数据
     * @param key
     * @return
     */
    public static final String SELECTSHAREDDATA(String key) {
        String content = sharedPreferences.getString(key, "");
        if (!content.equals("")) {
            return content;
        }
        return null;
    }



}
