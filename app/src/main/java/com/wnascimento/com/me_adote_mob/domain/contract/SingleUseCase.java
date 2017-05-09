package com.wnascimento.com.me_adote_mob.domain.contract;

import com.wnascimento.com.me_adote_mob.util.dagger.AndroidThread;
import com.wnascimento.com.me_adote_mob.util.dagger.IoThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public abstract class SingleUseCase<T> {

    private final Scheduler threadExecutor;
    private final Scheduler threadUi;

    protected SingleUseCase(Scheduler threadExecutor, Scheduler threadUi) {
        this.threadExecutor = threadExecutor;
        this.threadUi = threadUi;
    }

    public Single<T> run(Params params) {
        return buildUseCase(params)
                .observeOn(threadUi)
                .subscribeOn(threadExecutor);

    }

    protected abstract Single<T> buildUseCase(Params params);

}