package com.wnascimento.com.me_adote_mob.domain;


public class TestUseCaseScheduler implements UseCaseScheduler {
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override
    public <V extends UseCase.Response> void notifySuccess(V res, UseCase.Callback<V> callback) {
        callback.onSuccess(res);
    }

    @Override
    public <V extends UseCase.Response> void notifyError(UseCase.Callback<V> callback) {
        callback.onError();
    }
}
