package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.client.IOwnerClient;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerRetrofitRepository implements OwnerRepositoryContract {

    private final IOwnerClient ownerClient;

    @Inject
    public OwnerRetrofitRepository(IOwnerClient ownerClient) {
        this.ownerClient = ownerClient;
    }

    @Override
    public Single<OwnerContract> login(OwnerContract owner) {
        return Single.create(singleEmitter -> {
            ownerClient.getOwnerByEmail(owner.toEntity().getEmail()).enqueue(new Callback<OwnerEntity>() {
                @Override
                public void onResponse(Call<OwnerEntity> call, Response<OwnerEntity> response) {
                    OwnerContract ownerResponse = response.body().toModel();

                    if(ownerResponse != null && response.isSuccessful()) {
                        singleEmitter.onSuccess(ownerResponse);
                    } else {
                        singleEmitter.onSuccess(new UnregisteredOwner());
                    }
                }

                @Override
                public void onFailure(Call<OwnerEntity> call, Throwable throwable) {
                    singleEmitter.onError(throwable);
                }
            });
        });

    }

    @Override
    public Single<OwnerContract> findById(long id) {

        return Single.create(singleEmitter -> {
            ownerClient.getOwnerById(id).enqueue(new Callback<OwnerEntity>() {
                @Override
                public void onResponse(Call<OwnerEntity> call, Response<OwnerEntity> response) {
                    OwnerContract ownerResponse = response.body().toModel();

                    if(ownerResponse != null && response.isSuccessful()) {
                        singleEmitter.onSuccess(ownerResponse);
                    } else {
                        singleEmitter.onSuccess(new UnregisteredOwner());
                    }
                }

                @Override
                public void onFailure(Call<OwnerEntity> call, Throwable throwable) {
                    singleEmitter.onError(throwable);
                }
            });
        });
    }
}
