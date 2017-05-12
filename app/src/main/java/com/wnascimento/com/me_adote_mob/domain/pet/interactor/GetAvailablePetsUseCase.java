package com.wnascimento.com.me_adote_mob.domain.pet.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contract.PetRepositoryContract;
import com.wnascimento.com.me_adote_mob.domain.contract.FlowableUseCase;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public class GetAvailablePetsUseCase extends FlowableUseCase<PetContract, GetAvailablePetsUseCase.Request> {

    private final PetRepositoryContract petRepository;

    @Inject
    public GetAvailablePetsUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler threadUi,
                                   PetRepositoryContract petRepository) {
        super(threadExecutor, threadUi);
        this.petRepository = petRepository;
    }

    @Override
    protected Flowable<PetContract> buildUseCase(Request request) {
        return this.petRepository.getAvailablePets();
    }

    public static final class Request extends FlowableUseCase.Request {
    }

}
