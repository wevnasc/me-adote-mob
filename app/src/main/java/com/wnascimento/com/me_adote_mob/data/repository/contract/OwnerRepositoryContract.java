package com.wnascimento.com.me_adote_mob.data.repository.contract;

import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;

import io.reactivex.Single;

public interface OwnerRepositoryContract {

    Single<OwnerContract> login(OwnerContract owner);

    Single<OwnerContract> findById(long id);

}
