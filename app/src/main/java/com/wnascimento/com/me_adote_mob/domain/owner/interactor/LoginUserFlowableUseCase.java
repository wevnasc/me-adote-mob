package com.wnascimento.com.me_adote_mob.domain.owner.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.contract.SingleUseCase;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class LoginUserFlowableUseCase extends SingleUseCase<Boolean> {

    public static final String PARAMS_KEY_EMAIL = "PARAMS_KEY_EMAIL";
    public static final String PARAMS_KEY_PASSWORD = "PARAMS_KEY_PASSWORD";

    private final UserRepository userRepository;

    public LoginUserFlowableUseCase(Scheduler threadExecutor, Scheduler postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Single<Boolean> buildUseCase(Params params) {
        return null;
    }
}
