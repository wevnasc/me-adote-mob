package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.domain.UseCase;
import com.wnascimento.com.me_adote_mob.domain.UseCaseHandler;
import com.wnascimento.com.me_adote_mob.domain.login.entity.RegisteredUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.User;
import com.wnascimento.com.me_adote_mob.domain.login.usecase.LoginUseCase;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View loginView;
    private final LoginUseCase loginUseCase;
    private final UseCaseHandler handler;

    public LoginPresenter(LoginContract.View loginView, LoginUseCase loginUseCase, UseCaseHandler handler) {
        this.loginView = loginView;
        this.loginUseCase = loginUseCase;
        this.handler = handler;
        this.loginView.attachPresenter(this);
    }

    @Override
    public void reload() {

    }

    @Override
    public void close() {

    }

    @Override
    public void login(String email, String password) {
        User user = new RegisteredUser(email, password);

        if (!user.hasEmail()) {
            loginView.showMessageEmailNotValid();
        }
        if (!user.hasPassword()) {
            loginView.showMessagePasswordNotValid();
        }

        if (user.hasEmail() && user.hasPassword()) {

            handler.execute(loginUseCase, new LoginUseCase.Request(user), new UseCase.Callback<LoginUseCase.Response>() {
                @Override
                public void onSuccess(LoginUseCase.Response response) {
                    loginView.showPets();
                }

                @Override
                public void onError() {
                    loginView.message("Could not login");
                }
            });

        }

    }
}
