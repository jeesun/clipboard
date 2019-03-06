package com.simon.clipboard.common.interfaces;

import com.simon.clipboard.common.domain.ResultMsg;
import com.simon.clipboard.common.exception.NoNetworkException;
import com.simon.clipboard.common.exception.UserNotLoginException;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by simon on 2017/4/23.
 */

public interface RequestWithToken {
    @GET("/api/oauthUsers/userInfo")
    Call<ResultMsg> getUser(@Query("access_token") String access_token)  throws UserNotLoginException, NoNetworkException;
}
