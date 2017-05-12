package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.repository.contract.PetRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.client.IPetClient;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetRetrofitRepository implements PetRepositoryContract {

    private final IPetClient petClient;
    private final OwnerRepositoryContract ownerRepository;

    @Inject
    public PetRetrofitRepository(IPetClient petClient, OwnerRepositoryContract ownerRepository) {
        this.petClient = petClient;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Flowable<PetContract> getAvailablePets() {

        Flowable<List<PetEntity>> pets = Flowable.create(singleEmitter -> petClient.getAll()
                .enqueue(new Callback<List<PetEntity>>() {
                    @Override
                    public void onResponse(Call<List<PetEntity>> call, Response<List<PetEntity>> response) {
                        List<PetEntity> petEntities = response.body();
                        singleEmitter.onNext(petEntities);
                    }

                    @Override
                    public void onFailure(Call<List<PetEntity>> call, Throwable throwable) {
                        throwable.printStackTrace();
                        singleEmitter.onError(throwable);
                    }
                }), BackpressureStrategy.BUFFER);

        return pets.flatMap(Flowable::fromIterable)
                .flatMap(pet -> ownerRepository.findById(pet.getOwnerId())
                        .map(pet::toModel)
                        .toFlowable());

    }

    @Override
    public Completable save(PetContract pet) {
        return Completable.create(completableEmitter -> petClient.save(pet.toEntity())
                .enqueue(new Callback<PetEntity>() {
                    @Override
                    public void onResponse(Call<PetEntity> call, Response<PetEntity> response) {
                        System.out.println(response.body());
                        completableEmitter.onComplete();
                    }

                    @Override
                    public void onFailure(Call<PetEntity> call, Throwable throwable) {
                        throwable.printStackTrace();
                        completableEmitter.onError(throwable);
                    }
                }));

    }
}
