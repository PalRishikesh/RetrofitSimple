package com.example.march23.api;

import com.example.march23.models.DefaultResponse;
import com.example.march23.models.LoginResponse;
import com.example.march23.models.UsersAllResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register.php")
    Call<DefaultResponse> createUserPage(
           @Field("name") String name,
           @Field("user_name") String user_name,
           @Field("user_password") String user_password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> userLoginPage(
            @Field("user_name") String user_name,
            @Field("user_password") String user_password
    );

    @GET("get.php")
    Call<UsersAllResponse> getUsersinfo();
}
