package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

import java.util.Map;

import io.reactivex.Single;

public class OwnerFakeRepository implements IOwnerRepository {

    @Override
    public Single<IOwner> login(IOwner owner) {
        Map<String, IOwner> owners = Struct.getOwners();
        return Single.create(source -> {
            if (owners.values().contains(owner)) {
                source.onSuccess(owner);
            } else {
                source.onSuccess(new UnregisteredOwner());
            }
        });

    }
}
