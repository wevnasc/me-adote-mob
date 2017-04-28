package com.wnascimento.autodoc.me_adote_mob.domain.adoption;

public interface Executor<T> {

    void onNext(T value);
    void onError(Throwable error);
    void completed();

}
