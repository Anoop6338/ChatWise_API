package com.example.chatwise_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
    Call<MyData> getProducts();
}
