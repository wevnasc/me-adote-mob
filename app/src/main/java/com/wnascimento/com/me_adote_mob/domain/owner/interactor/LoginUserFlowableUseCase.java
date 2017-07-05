package com.wnascimento.com.me_adote_mob.domain.owner.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.domain.contract.SingleUseCase;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginUserFlowableUseCase extends SingleUseCase<Boolean, LoginUserFlowableUseCase.Request> {

    private final OwnerRepositoryContract ownerRepository;

    @Inject
    public LoginUserFlowableUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler postExecutionThread, OwnerRepositoryContract ownerRepository) {
        super(threadExecutor, postExecutionThread);
        this.ownerRepository = ownerRepository;
    }

    @Override
    protected Single<Boolean> buildUseCase(Request request) {
        return ownerRepository.login(request.getOwner()).map(OwnerContract::hasRegistred);
    }

    public static final class Request extends SingleUseCase.Request {

        private final OwnerContract owner;

        public Request(OwnerContract owner) {
            this.owner = owner;
        }

        public OwnerContract getOwner() {
            return owner;
        }
    }
}
