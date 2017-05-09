package com.wnascimento.com.me_adote_mob.domain.owner.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.contract.SingleUseCase;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginUserFlowableUseCase extends SingleUseCase<Boolean> {

    public static final String PARAMS_KEY_EMAIL = "PARAMS_KEY_EMAIL";
    public static final String PARAMS_KEY_PASSWORD = "PARAMS_KEY_PASSWORD";

    private final IOwnerRepository ownerRepository;

    @Inject
    public LoginUserFlowableUseCase(@IoThread Scheduler threadExecutor, @AndroidThread Scheduler postExecutionThread, IOwnerRepository ownerRepository) {
        super(threadExecutor, postExecutionThread);
        this.ownerRepository = ownerRepository;
    }

    @Override
    protected Single<Boolean> buildUseCase(Params params) {

        Owner owner = new Owner(params.getString(PARAMS_KEY_EMAIL, ""),
                params.getString(PARAMS_KEY_PASSWORD, ""));

        return ownerRepository.login(owner).map(IOwner::hasRegistred);
    }
}
