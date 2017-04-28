package com.wnascimento.autodoc.me_adote_mob.presentation.login;

import com.wnascimento.autodoc.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.autodoc.me_adote_mob.presentation.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void message(String message);
    }

    interface Presenter extends BasePresenter{
        void login(String email, String password);
    }

}
