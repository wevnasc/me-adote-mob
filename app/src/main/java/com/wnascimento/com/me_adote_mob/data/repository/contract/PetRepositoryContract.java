package com.wnascimento.com.me_adote_mob.data.repository.contract;

import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface PetRepositoryContract {

    Flowable<PetContract> getAvailablePets();

    Completable save(PetContract pet);

}
