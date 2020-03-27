package com.example.retrofitconfigrasyonu.RestApi;

import com.example.retrofitconfigrasyonu.Models.Bilgiler;
import com.example.retrofitconfigrasyonu.Models.Resault;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/comments")
    Call<List<Bilgiler>> getir();

    @GET("/comments")
    Call<List<Resault>> getirResault(@Query("postId") String postid, @Query("id") String id);

}
