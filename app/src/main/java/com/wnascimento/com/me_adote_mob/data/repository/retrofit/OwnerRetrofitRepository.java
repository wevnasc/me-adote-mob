package com.wnascimento.com.me_adote_mob.data.repository.retrofit;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.data.repository.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

import javax.inject.Inject;

import io.reactivex.Single;

public class OwnerRetrofitRepository implements IOwnerRepository {

    private final IOwnerClient ownerClient;

    @Inject
    public OwnerRetrofitRepository(IOwnerClient ownerClient) {
        this.ownerClient = ownerClient;
    }

    @Override
    public Single<IOwner> login(IOwner owner) {
        return ownerClient.getOwnerByEmail(owner.toEntity().getEmail())
                .map(OwnerEntity::toModel)
                .firstOrError();
    }
}
