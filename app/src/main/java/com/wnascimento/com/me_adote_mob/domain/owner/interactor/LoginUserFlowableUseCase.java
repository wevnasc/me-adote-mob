package com.wnascimento.com.me_adote_mob.domain.owner.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.SingleUseCase;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginUserFlowableUseCase extends SingleUseCase<Boolean, LoginUserFlowableUseCase.Request> {

    private final IOwnerRepository ownerRepository;

    @Inject
    public LoginUserFlowableUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler postExecutionThread, IOwnerRepository ownerRepository) {
        super(threadExecutor, postExecutionThread);
        this.ownerRepository = ownerRepository;
    }

    @Override
    protected Single<Boolean> buildUseCase(Request request) {
        return ownerRepository.login(request.getOwner()).map(IOwner::hasRegistred);
    }

    public static final class Request extends SingleUseCase.Request {

        private final IOwner owner;

        public Request(IOwner owner) {
            this.owner = owner;
        }

        public IOwner getOwner() {
            return owner;
        }
    }
}
