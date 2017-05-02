package com.wnascimento.com.me_adote_mob.data.repository.contracts;

public interface Executor<T> {

    void onNext(T value);

    void onError();

}
