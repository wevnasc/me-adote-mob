package com.wnascimento.com.me_adote_mob.domain.contract;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public abstract class SingleUseCase<T, R extends SingleUseCase.Request> {

    private final Scheduler threadExecutor;
    private final Scheduler threadUi;

    protected SingleUseCase(Scheduler threadExecutor, Scheduler threadUi) {
        this.threadExecutor = threadExecutor;
        this.threadUi = threadUi;
    }

    public Single<T> run(R request) {
        return buildUseCase(request)
                .observeOn(threadUi)
                .subscribeOn(threadExecutor);

    }

    protected abstract Single<T> buildUseCase(R request);

    public static class Request {

    }

}