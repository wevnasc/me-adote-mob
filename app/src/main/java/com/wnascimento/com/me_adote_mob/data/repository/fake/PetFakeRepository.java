package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.data.repository.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class PetFakeRepository implements IPetRepository {

    private static PetFakeRepository INSTANCE;

    private static Map<String, PetEntity> petStruct;

    public static PetFakeRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PetFakeRepository();
            petStruct = new HashMap<>();
            petStruct = Struct.getPets();
        }
        return INSTANCE;
    }

    @Override
    public Flowable<IPet> getAvailablePets() {
        return Flowable.fromIterable(petStruct.values())
                .map(petEntity -> petEntity.toModel(Struct.getOwners().get("1").toModel()))
                .filter(pet -> !pet.isAdopted());
    }

    @Override
    public Completable save(IPet pet) {
        return Completable.create(emitter -> {
            petStruct.put(UUID.randomUUID().toString(), pet.toEntity());
            emitter.onComplete();
        });
    }

}
