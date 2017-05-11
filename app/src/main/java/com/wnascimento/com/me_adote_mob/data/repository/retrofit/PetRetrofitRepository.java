package com.wnascimento.com.me_adote_mob.data.repository.retrofit;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class PetRetrofitRepository implements IPetRepository {

    private final IPetClient petClient;

    @Inject
    public PetRetrofitRepository(IPetClient petClient) {
        this.petClient = petClient;
    }

    @Override
    public Flowable<IPet> getAvailablePets() {
        return petClient.getAll().map(petEntity -> petEntity.toModel(new UnregisteredOwner()));
    }

    @Override
    public Completable save(IPet pet) {
        return petClient.save(pet.toEntity()).toCompletable();
    }
}
