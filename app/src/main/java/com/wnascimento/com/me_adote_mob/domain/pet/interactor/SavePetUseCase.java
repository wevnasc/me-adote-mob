package com.wnascimento.com.me_adote_mob.domain.pet.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contract.PetRepositoryContract;
import com.wnascimento.com.me_adote_mob.domain.contract.CompletableUseCase;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Scheduler;

public class SavePetUseCase extends CompletableUseCase<SavePetUseCase.Request> {

    private final PetRepositoryContract petRepository;

    @Inject
    public SavePetUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler threadUi, PetRepositoryContract petRepository) {
        super(threadExecutor, threadUi);
        this.petRepository = petRepository;
    }

    @Override
    protected Completable buildUseCase(Request request) {
        PetContract pet = request.getPet();
        pet.setOwner(new Owner("1", "", "" ,"" ,""));
        return petRepository.save(pet);
    }

    public static final class Request extends CompletableUseCase.Request{

        PetContract pet;

        public Request(PetContract pet) {
            this.pet = pet;
        }

        public PetContract getPet() {
            return pet;
        }
    }
}
