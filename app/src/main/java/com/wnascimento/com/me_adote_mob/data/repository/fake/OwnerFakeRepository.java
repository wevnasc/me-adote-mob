package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;

public class OwnerFakeRepository implements OwnerRepositoryContract {

    private static OwnerFakeRepository INSTANCE;

    private static Map<String, OwnerEntity> ownerStruct;


    public static OwnerFakeRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OwnerFakeRepository();
            ownerStruct = new HashMap<>();
            ownerStruct = Struct.getOwners();
        }
        return INSTANCE;
    }

    public OwnerFakeRepository() {
        ownerStruct = Struct.getOwners();
    }

    @Override
    public Single<OwnerContract> login(OwnerContract owner) {
        return Single.create(emitter -> {
            if (ownerStruct.values().contains(owner.toEntity())) {
                emitter.onSuccess(owner);
            } else {
                emitter.onSuccess(new UnregisteredOwner());
            }
        });
    }

    @Override
    public Single<OwnerContract> findById(long id) {
        return Single.create(emitter -> emitter.onSuccess(ownerStruct.get(id).toModel()));
    }
}
