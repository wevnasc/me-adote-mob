package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class PetFakeRepository implements IPetRepository {

    private Map<String, IPet> petStruct = new HashMap<>();

    public PetFakeRepository() {
        this.petStruct = Struct.getPets();
    }

    @Override
    public Flowable<IPet> getAvailablePets() {
        return Flowable.fromIterable(petStruct.values())
                .filter(pet -> !pet.isAdopted());
    }

    @Override
    public Completable save(IPet pet) {
        return Completable.create(emitter -> {
            petStruct.put(UUID.randomUUID().toString(), pet);
            emitter.onComplete();
        });
    }

}
