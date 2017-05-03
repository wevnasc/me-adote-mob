package com.wnascimento.com.me_adote_mob.presentation;

import com.wnascimento.com.me_adote_mob.domain.login.interactor.LoginUserUseCase;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginContract;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginPresenter;


public class LoginPresenterTestFactory {

    public LoginContract.Presenter make(LoginContract.View view, LoginUserUseCase loginUserUseCase) {
        return new LoginPresenter(view, loginUserUseCase);
    }

}
