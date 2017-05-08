package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

import io.reactivex.Single;

public interface IOwnerRepository {

    Single<IOwner> login(IOwner owner);

}
