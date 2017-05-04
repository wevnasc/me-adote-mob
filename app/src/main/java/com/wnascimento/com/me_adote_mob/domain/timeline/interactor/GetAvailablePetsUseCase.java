package com.wnascimento.com.me_adote_mob.domain.timeline.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.PetRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.FlowableUseCase;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;

import java.util.Collections;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public class GetAvailablePetsUseCase extends FlowableUseCase<AvailablePet> {

    private final PetRepository petRepository;

    public GetAvailablePetsUseCase(Scheduler threadExecutor, Scheduler threadUi, PetRepository petRepository) {
        super(threadExecutor, threadUi);
        this.petRepository = petRepository;
    }

    @Override
    protected Flowable<AvailablePet> buildUseCase(Params params) {
        return this.petRepository.getAvailablePets()
                .sorted(Collections.reverseOrder((p1, p2) -> p1.getCreatedAt().compareTo(p2.getCreatedAt())));
    }

}
