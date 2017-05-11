package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.wnascimento.com.me_adote_mob.data.repository.entity.OwnerEntity;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOwnerClient {

    @GET("/api/owners/search/findByEmail")
    Flowable<OwnerEntity> getOwnerByEmail(@Query("email") String email);

}
