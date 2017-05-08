package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import io.reactivex.Flowable;

public interface IPetRepository {

    Flowable<IPet> getAvailablePets();

}
