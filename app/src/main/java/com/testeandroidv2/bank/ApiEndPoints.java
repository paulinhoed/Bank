package com.testeandroidv2.bank;

import com.testeandroidv2.bank.loginScreen.ApiLoginModel;
import com.testeandroidv2.bank.loginScreen.LoginModel;
import com.testeandroidv2.bank.statementScreen.ApiStatementModel;
import com.testeandroidv2.bank.statementScreen.StatementModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {

    @POST("login")
    Call<ApiLoginModel> postLogin(@Body LoginModel login);

    @GET("statements/{userId}")
    Call<ApiStatementModel> getStatement(@Path("userId") String userId);
}
