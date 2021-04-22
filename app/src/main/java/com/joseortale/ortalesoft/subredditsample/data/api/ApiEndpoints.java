package com.joseortale.ortalesoft.subredditsample.data.api;

import com.joseortale.ortalesoft.subredditsample.model.Submission;
import com.joseortale.ortalesoft.subredditsample.model.apiresponse.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoints {
    @GET("hot.json")
    Call<ApiResponse> getAllByPage(@Query("after") String after);

    @GET("hot.json")
    Call<ApiResponse> getAll();
}
