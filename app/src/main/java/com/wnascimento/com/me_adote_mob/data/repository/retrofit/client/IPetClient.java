package com.wnascimento.com.me_adote_mob.data.repository.retrofit.client;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IPetClient {

    @GET("/api/pets")
    Call<List<PetEntity>> getAll();

    @Headers("Content-Type: application/hal+json")
    @POST("/api/pets")
    Call<PetEntity> save(@Body PetEntity pet);

}
