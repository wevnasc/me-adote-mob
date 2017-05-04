package com.wnascimento.com.me_adote_mob.domain.contract;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public abstract class FlowableUseCase<T> {

    private final Scheduler threadExecutor;
    private final Scheduler threadUi;

    protected FlowableUseCase(Scheduler threadExecutor, Scheduler threadUi) {
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
