package com.wnascimento.com.me_adote_mob.data.repository.retrofit.client;

import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IOwnerClient {

    @GET("/api/owners/search/findByEmail")
    Call<OwnerEntity> getOwnerByEmail(@Query("email") String email);

    @GET("/api/owners/{id}")
    Call<OwnerEntity> getOwnerById(@Path("id") long id);

}
