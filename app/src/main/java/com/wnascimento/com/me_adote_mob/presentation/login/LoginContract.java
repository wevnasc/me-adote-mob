package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showMessageUserNotFound();

        void showMessageEmailNotValid();

        void showMessagePasswordNotValid();

        void goToPets();
    }

    interface Presenter extends BasePresenter {
        void login(String email, String password);
    }

}
