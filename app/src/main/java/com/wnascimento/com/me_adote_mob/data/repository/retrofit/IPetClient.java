package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.wnascimento.com.me_adote_mob.data.repository.entity.PetEntity;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IPetClient {

    @GET("/api/pets")
    Flowable<PetEntity> getAll();

    @POST("/api/pets")
    Single<PetEntity> save(@Body PetEntity pet);

}
