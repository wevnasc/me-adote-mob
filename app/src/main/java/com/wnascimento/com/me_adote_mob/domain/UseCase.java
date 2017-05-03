package com.wnascimento.com.me_adote_mob.domain;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public abstract class UseCase<T> {

    private final Scheduler threadExecutor;
    private final Scheduler threadUi;

    protected UseCase(Scheduler threadExecutor, Scheduler threadUi) {
        this.threadExecutor = threadExecutor;
        this.threadUi = threadUi;
    }

    public Flowable<T> run(Params params) {
        return buildUseCase(params)
                .observeOn(threadUi)
                .subscribeOn(threadExecutor);

    }

    protected abstract Flowable<T> buildUseCase(Params params);

}
