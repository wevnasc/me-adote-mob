package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.owner.model.Authenticable;

import io.reactivex.Single;

public interface UserRepository {

    Single<Authenticable> login(Authenticable user);

}
