package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void message(String message);

        void showMessageEmailNotValid();

        void showMessagePasswordNotValid();

        void showPets();
    }

    interface Presenter extends BasePresenter {
        void login(String email, String password);
    }

}
