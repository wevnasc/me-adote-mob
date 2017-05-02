package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.data.repository.fake.UserFakeRepository;
import com.wnascimento.com.me_adote_mob.domain.UseCaseHandler;
import com.wnascimento.com.me_adote_mob.domain.UseCaseThreadPoolScheduler;
import com.wnascimento.com.me_adote_mob.domain.login.usecase.LoginUseCase;

public class LoginPresenterFactory {

    public LoginContract.Presenter make(LoginContract.View view) {
        return new LoginPresenter(view,
                new LoginUseCase(new UserFakeRepository()),
                UseCaseHandler.getInstance(new UseCaseThreadPoolScheduler()));
    }

}
