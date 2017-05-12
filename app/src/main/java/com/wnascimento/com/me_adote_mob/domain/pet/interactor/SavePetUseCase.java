package com.wnascimento.com.me_adote_mob.domain.pet.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.CompletableUseCase;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Scheduler;

public class SavePetUseCase extends CompletableUseCase<SavePetUseCase.Request> {

    private final IPetRepository petRepository;

    @Inject
    public SavePetUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler threadUi, IPetRepository petRepository) {
        super(threadExecutor, threadUi);
        this.petRepository = petRepository;
    }

    @Override
    protected Completable buildUseCase(Request request) {
        return petRepository.save(request.getPet());
    }

    public static final class Request extends CompletableUseCase.Request{

        IPet pet;

        public Request(IPet pet) {
            this.pet = pet;
        }

        public IPet getPet() {
            return pet;
        }
    }
}
