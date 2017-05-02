package com.wnascimento.com.me_adote_mob.domain;

public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.Response> void notifySuccess(final V res, final UseCase.Callback<V> callback);

    <V extends UseCase.Response> void notifyError(final UseCase.Callback<V> callback);

}
