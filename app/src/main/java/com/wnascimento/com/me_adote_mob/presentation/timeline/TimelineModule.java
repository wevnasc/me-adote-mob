package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.presentation.login.LoginContract;

import dagger.Module;
import dagger.Provides;

@Module
public class TimelineModule {

    private final TimelineContract.View view;

    public TimelineModule(TimelineContract.View view) {
        this.view = view;
    }

    @Provides
    public TimelineContract.View getView() {
        return view;
    }

}
