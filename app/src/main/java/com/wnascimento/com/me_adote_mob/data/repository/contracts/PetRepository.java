package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;

import io.reactivex.Flowable;

public interface PetRepository {

    Flowable<AvailablePet> getAvailablePets();

}
