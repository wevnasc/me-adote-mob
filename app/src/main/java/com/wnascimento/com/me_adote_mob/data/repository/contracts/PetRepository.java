package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.pet.model.Pet;

import io.reactivex.Flowable;

public interface PetRepository {

    Flowable<Pet> getAvailablePets();

}
