package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;

public class OwnerFakeRepository implements IOwnerRepository {

    private Map<String, IOwner> ownerStruct = new HashMap<>();

    public OwnerFakeRepository() {
        this.ownerStruct = Struct.getOwners();
    }

    @Override
    public Single<IOwner> login(IOwner owner) {
        return Single.create(emitter -> {
            if (ownerStruct.values().contains(owner)) {
                emitter.onSuccess(owner);
            } else {
                emitter.onSuccess(new UnregisteredOwner());
            }
        });

    }
}
