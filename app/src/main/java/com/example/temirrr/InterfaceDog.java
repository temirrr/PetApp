package com.example.temirrr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceDog {
    @GET("woof.json")
    Call<Post> getPost(@Query("filter") String filterFormat); //"filter" is the ?filter=... parameter
}
