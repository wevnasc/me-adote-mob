package com.wnascimento.com.me_adote_mob;


import android.content.Context;

import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context getContext() {
        return context;
    }

    @AndroidThread
    @Singleton
    @Provides
    public Scheduler getAndroidThread() {
        return AndroidSchedulers.mainThread();
    }

    @IoThread
    @Singleton
    @Provides
    public Scheduler getIoThread() {
        return Schedulers.io();
    }

}
