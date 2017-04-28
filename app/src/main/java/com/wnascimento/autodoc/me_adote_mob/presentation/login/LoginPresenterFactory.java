package com.wnascimento.autodoc.me_adote_mob.presentation.login;

import com.wnascimento.autodoc.me_adote_mob.domain.adoption.usecase.ValidateCredentialsUseCase;
import com.wnascimento.autodoc.me_adote_mob.domain.data.repository.fake.OwnerFakeRepository;

public class LoginPresenterFactory {

    public LoginContract.Presenter make(LoginContract.View view) {
        return new LoginPresenter(view, new ValidateCredentialsUseCase(new OwnerFakeRepository()));
    }

}
