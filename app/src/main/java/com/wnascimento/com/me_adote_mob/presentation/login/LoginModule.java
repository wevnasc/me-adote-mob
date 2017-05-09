package com.wnascimento.com.me_adote_mob.presentation.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginContract.View view;


    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    public LoginContract.View getView() {
        return view;
    }
}
