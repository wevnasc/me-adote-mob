package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.login.model.Authenticable;

import io.reactivex.Flowable;

public interface UserRepository {

    Flowable<Authenticable> login(Authenticable user);

}
