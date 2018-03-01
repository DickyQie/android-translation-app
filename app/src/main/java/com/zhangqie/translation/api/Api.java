package com.zhangqie.translation.api;

import com.zhangqie.translation.tool.UtilTools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangqie on 2018/2/28.
 */

public class Api {

    public static Map<String,Object> showTranslation(String data,String type)
    {
        Map<String, Object> map = new HashMap<>();
        String sign ="20180226000127310"+data+"1435660288K7vuNn2OfyYilpevb29x";
        map.put("q",data);
        map.put("from","auto");
        map.put("to",type);
        map.put("appid", "20180226000127310");
        map.put("salt","1435660288");
        map.put("sign", UtilTools.stringToMD5(sign));
        return map;
    }
}
