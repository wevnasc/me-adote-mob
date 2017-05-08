package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.domain.owner.interactor.LoginUserFlowableUseCase;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View loginView;
    private final LoginUserFlowableUseCase loginUseCase;
    private final CompositeDisposable compositeDisposable;

    public LoginPresenter(LoginContract.View loginView, LoginUserFlowableUseCase loginUseCase) {
        this.loginView = loginView;
        this.loginUseCase = loginUseCase;
        this.loginView.attachPresenter(this);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void reload() {

    }

    @Override
    public void close() {
        compositeDisposable.clear();
    }

    @Override
    public void login(String email, String password) {
        IOwner user = new Owner(email, password);

        if (!user.hasEmail()) {
            loginView.showMessageEmailNotValid();
            return;
        }
        if (!user.hasPassword()) {
            loginView.showMessagePasswordNotValid();
            return;
        }

        Params params = Params.create();
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_EMAIL, email);
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_PASSWORD, password);
        loginUseCase.run(params).subscribeWith(new LoginUserObservable());
    }


    public class LoginUserObservable implements SingleObserver<Boolean> {
        @Override
        public void onSubscribe(Disposable disposable) {
            compositeDisposable.add(disposable);
        }

        @Override
        public void onSuccess(Boolean registered) {
            if (registered) {
                loginView.goToPets();
            } else {
                loginView.showMessageUserNotFound();
            }
        }

        @Override
        public void onError(Throwable t) {
            loginView.showMessageUserNotFound();
        }

    }

}
