package com.noobs.caloriecounter.rest;

import com.noobs.caloriecounter.models.LoginReq;
import com.noobs.caloriecounter.models.LoginResp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResp> getUser(@Field("email")  String email,
                            @Field("password") String password);
}
