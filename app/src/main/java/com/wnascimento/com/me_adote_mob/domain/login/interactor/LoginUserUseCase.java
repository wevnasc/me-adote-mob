package com.wnascimento.com.me_adote_mob.domain.login.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.Params;
import com.wnascimento.com.me_adote_mob.domain.UseCase;
import com.wnascimento.com.me_adote_mob.domain.login.model.Authenticable;
import com.wnascimento.com.me_adote_mob.domain.login.model.User;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public class LoginUserUseCase extends UseCase<Boolean> {

    public static final String PARAMS_KEY_EMAIL = "PARAMS_KEY_EMAIL";
    public static final String PARAMS_KEY_PASSWORD = "PARAMS_KEY_PASSWORD";

    private final UserRepository userRepository;

    public LoginUserUseCase(Scheduler threadExecutor, Scheduler postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Flowable<Boolean> buildUseCase(Params params) {
        Authenticable user = new User(params.getString(PARAMS_KEY_EMAIL, ""),
                params.getString(PARAMS_KEY_PASSWORD, ""));
        return userRepository.login(user).map(Authenticable::isLogged);
    }
}
