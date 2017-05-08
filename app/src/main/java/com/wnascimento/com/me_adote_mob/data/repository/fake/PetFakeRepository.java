package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import io.reactivex.Flowable;

public class PetFakeRepository implements IPetRepository {

    @Override
    public Flowable<IPet> getAvailablePets() {
        return Flowable.fromIterable(Struct.getPets().values())
                .filter(pet -> !pet.isAdopted());
    }

}
