package com.zhangqie.translation.api;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by zhangqie on 2017/5/15.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("service/getIpInfo.php")
    Observable<String> login(@FieldMap Map<String, Object> map);

    @GET("/repos/square/retrofit/contributors")
    Observable<String> repoContributors1();


    //https://tcc.taobao.com/?
    //http://api.map.baidu.com/telematics/v3/weather?location=%E7%BB%A5%E5%BE%B7&output=json&ak=11ffd27d38deda622f51c9d314d46b17
    @GET("telematics/v3/weather")
    Observable<String> getUser(@QueryMap Map<String,Object> map);


    @POST("api/trans/vip/translate")
    Observable<String> getTranslationRequest(@QueryMap Map<String,Object> map);

}
