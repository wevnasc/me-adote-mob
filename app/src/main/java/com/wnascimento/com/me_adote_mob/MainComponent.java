package com.wnascimento.com.me_adote_mob;

import android.content.Context;

import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Scheduler;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    Context getContext();

    @AndroidThread
    Scheduler getAndroidThread();

    @IoThread
    Scheduler getIoThread();

}
