package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.data.repository.fake.OwnerFakeRepository;
import com.wnascimento.com.me_adote_mob.domain.owner.interactor.LoginUserFlowableUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterFactory {

    public LoginContract.Presenter make(LoginContract.View view) {
        return new LoginPresenter(view,
                new LoginUserFlowableUseCase(Schedulers.io(), AndroidSchedulers.mainThread(),
                        new OwnerFakeRepository()));
    }

}
