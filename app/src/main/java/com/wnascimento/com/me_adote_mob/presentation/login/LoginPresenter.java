package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.domain.Params;
import com.wnascimento.com.me_adote_mob.domain.login.interactor.LoginUserUseCase;
import com.wnascimento.com.me_adote_mob.domain.login.model.Authenticable;
import com.wnascimento.com.me_adote_mob.domain.login.model.User;

import io.reactivex.subscribers.DisposableSubscriber;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View loginView;
    private final LoginUserUseCase loginUseCase;

    public LoginPresenter(LoginContract.View loginView, LoginUserUseCase loginUseCase) {
        this.loginView = loginView;
        this.loginUseCase = loginUseCase;
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
        Authenticable user = new User(email, password);

        if (!user.hasEmail()) {
            loginView.showMessageEmailNotValid();
            return;
        }
        if (!user.hasPassword()) {
            loginView.showMessagePasswordNotValid();
            return;
        }

        Params params = Params.create();
        params.put(LoginUserUseCase.PARAMS_KEY_EMAIL, email);
        params.put(LoginUserUseCase.PARAMS_KEY_PASSWORD, password);
        loginUseCase.run(params).subscribeWith(new LoginUserObservable());
    }


    public class LoginUserObservable extends DisposableSubscriber<Boolean> {

        @Override
        public void onNext(Boolean authenticated) {
            if (authenticated) {
                loginView.goToPets();
            } else {
                loginView.showMessageUserNotFound();
            }
        }

        @Override
        public void onError(Throwable t) {
            loginView.showMessageUserNotFound();
        }

        @Override
        public void onComplete() {

        }
    }

}
