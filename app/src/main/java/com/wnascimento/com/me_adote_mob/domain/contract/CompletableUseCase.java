package com.wnascimento.com.me_adote_mob.domain.contract;

import io.reactivex.Completable;
import io.reactivex.Scheduler;

public abstract class CompletableUseCase<R extends CompletableUseCase.Request> {

    private final Scheduler threadExecutor;
    private final Scheduler threadUi;

    protected CompletableUseCase(Scheduler threadExecutor, Scheduler threadUi) {
        this.threadExecutor = threadExecutor;
        this.threadUi = threadUi;
    }

    public Completable run(R request) {
        return buildUseCase(request)
                .observeOn(threadUi)
                .subscribeOn(threadExecutor);

    }

    protected abstract Completable buildUseCase(R request);

    public static class Request {

    }

}