package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.repository.contract.PetRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.client.Deserializer;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.client.IOwnerClient;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.client.IPetClient;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryRetrofitModule {

    private static final String BASE_URL = "http://192.168.10.166:9090";

    @Provides
    OkHttpClient.Builder getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .addInterceptor(logging);
    }

    @Provides
    Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(OwnerEntity.class, new Deserializer<OwnerEntity>())
                .registerTypeAdapter(List.class, new Deserializer<List<PetEntity>>())
                .registerTypeAdapter(PetEntity.class, new Deserializer<PetEntity>())
                .create();
    }

    @Provides
    Retrofit.Builder getRetrofitBuilder(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    @Provides
    Retrofit getRetrofit(Retrofit.Builder retrofitBuilder, OkHttpClient.Builder okHttpBuilder) {
        return retrofitBuilder.client(okHttpBuilder.build()).build();
    }

    @Provides
    IOwnerClient getOwnerClient(Retrofit retrofit) {
        return retrofit.create(IOwnerClient.class);
    }

    @Provides
    IPetClient getPetClient(Retrofit retrofit) {
        return retrofit.create(IPetClient.class);
    }

    @Provides
    PetRepositoryContract getPetRepository(IPetClient petClient, OwnerRepositoryContract ownerRepository) {
        return new PetRetrofitRepository(petClient, ownerRepository);
    }

    @Provides
    OwnerRepositoryContract getOwnersRepository(IOwnerClient ownerClient) {
        return new OwnerRetrofitRepository(ownerClient);
    }

}
