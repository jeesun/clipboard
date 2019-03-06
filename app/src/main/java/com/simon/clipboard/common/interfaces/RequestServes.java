package com.simon.clipboard.common.interfaces;

import com.simon.clipboard.common.domain.ResultMsg;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RequestServes {
    //app扫描网页二维码登录
    @POST("/api/qrCodes/loginByQrCode")
    Observable<ResultMsg> loginByQrCode(@Query("access_token") String access_token,
                                        @Query("username") String username,
                                        @Query("sid") String sid);

    //账号密码登录
    @GET("/api/oauthUsers/{phone}/{password}")
    Observable<ResultMsg> login(@Path("phone") String phone,
                                @Path("password") String password);

    //使用refresh_token刷新access_token
    @POST("/api/oauthUsers/refreshToken")
    Observable<ResultMsg> refreshToken(@Query("refresh_token") String refresh_token);

    @GET("/jsonapi")
    Call<ResponseBody> jsonApi(
            @Query("jsonversion") Integer jsonversion,
            @Query("client") String client,
            @Query("q") String q,
            @Query("dicts") String dicts,
            @Query("keyfrom") String keyfrom,
            @Query("model") String model,
            @Query("mid") String mid,
            @Query("imei") String imei,
            @Query("vendor") String vendor,
            @Query("screen") String screen,
            @Query("ssid") String ssid,
            @Query("network") String network,
            @Query("abtest") String abtest,
            @Query("xmlVersion") String xmlVersion);
}
