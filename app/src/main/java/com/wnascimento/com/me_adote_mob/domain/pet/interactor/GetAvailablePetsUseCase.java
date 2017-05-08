package com.wnascimento.com.me_adote_mob.domain.pet.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.FlowableUseCase;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

import java.util.Collections;
import java.util.Date;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public class GetAvailablePetsUseCase extends FlowableUseCase<IPet> {

    private final IPetRepository petRepository;

    public GetAvailablePetsUseCase(Scheduler threadExecutor, Scheduler threadUi, IPetRepository petRepository) {
        super(threadExecutor, threadUi);
        this.petRepository = petRepository;
    }

    @Override
    protected Flowable<IPet> buildUseCase(Params params) {
        return this.petRepository.getAvailablePets()
                .sorted(Collections.reverseOrder((p1, p2) ->
                        new Date(p1.getCreatedAt()).compareTo(new Date(p2.getCreatedAt()))));
    }

}
