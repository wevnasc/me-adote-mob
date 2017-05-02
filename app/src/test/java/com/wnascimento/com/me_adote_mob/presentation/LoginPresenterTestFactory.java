package com.wnascimento.com.me_adote_mob.presentation;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.TestUseCaseScheduler;
import com.wnascimento.com.me_adote_mob.domain.UseCaseHandler;
import com.wnascimento.com.me_adote_mob.domain.login.usecase.LoginUseCase;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginContract;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginPresenter;


public class LoginPresenterTestFactory {

    public LoginContract.Presenter make(LoginContract.View view, UserRepository userRepository) {
        return new LoginPresenter(view, new LoginUseCase(userRepository),
                UseCaseHandler.getInstance(new TestUseCaseScheduler()));
    }

}
