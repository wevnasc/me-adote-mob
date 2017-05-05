package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.domain.owner.interactor.LoginUserFlowableUseCase;


public class LoginPresenterTestFactory {

    public LoginContract.Presenter make(LoginContract.View view, LoginUserFlowableUseCase loginUserUseCase) {
        return new LoginPresenter(view, loginUserUseCase);
    }

}
