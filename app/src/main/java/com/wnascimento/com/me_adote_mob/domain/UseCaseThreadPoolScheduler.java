package com.wnascimento.com.me_adote_mob.domain;


import android.os.Handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseCaseThreadPoolScheduler implements UseCaseScheduler {

    public static final int POOL_SIZE = 2;
    public static final int MAX_POOL_SIZE = 4;
    public static final int TIMEOUT = 30;

    private final Handler handler = new Handler();
    private ThreadPoolExecutor threadPoolExecutor;

    public UseCaseThreadPoolScheduler() {
        threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE,
                TIMEOUT, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(POOL_SIZE));
    }

    @Override
    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    @Override
    public <V extends UseCase.Response> void notifySuccess(final V res, final UseCase.Callback<V> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(res);
            }
        });
    }

    @Override
    public <V extends UseCase.Response> void notifyError(final UseCase.Callback<V> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }
}
