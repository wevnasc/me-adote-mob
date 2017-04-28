package com.wnascimento.autodoc.me_adote_mob.presentation.login;

import com.wnascimento.autodoc.me_adote_mob.domain.adoption.Executor;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.entity.Owner;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.usecase.ValidateCredentialsUseCase;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View loginView;
    private final ValidateCredentialsUseCase validateCredentialsUseCase;

    public LoginPresenter(LoginContract.View loginView, ValidateCredentialsUseCase validateCredentialsUseCase) {
        this.loginView = loginView;
        this.validateCredentialsUseCase = validateCredentialsUseCase;
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

        validateCredentialsUseCase.execute(new ValidateCredentialsUseCase.Request(email, password), new Executor<Owner>() {
            @Override
            public void onNext(Owner value) {

            }

            @Override
            public void onError(Throwable error) {
                loginView.message(error.getMessage());
            }

            @Override
            public void completed() {
                loginView.message("Login Completed!");
            }
        });

    }
}
