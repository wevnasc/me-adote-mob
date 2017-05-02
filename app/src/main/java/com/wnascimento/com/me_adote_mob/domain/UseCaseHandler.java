package com.wnascimento.com.me_adote_mob.domain;

public class UseCaseHandler {

    private static UseCaseHandler INSTANCE;

    private final UseCaseScheduler useCaseScheduler;

    private UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        this.useCaseScheduler = useCaseScheduler;
    }

    public static UseCaseHandler getInstance(UseCaseScheduler useCaseScheduler) {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(useCaseScheduler);
        }
        return INSTANCE;
    }

    public <T extends UseCase.Request, R extends UseCase.Response> void execute(final UseCase<T, R> useCase, final T request, final UseCase.Callback<R> callback) {

        useCase.setRequest(request);
        useCase.setCallback(new UiCallback(callback, this));

        useCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    private <V extends UseCase.Response> void notifySuccess(final V response,
                                                            final UseCase.Callback<V> callback) {
        useCaseScheduler.notifySuccess(response, callback);
    }

    private <V extends UseCase.Response> void notifyError(final UseCase.Callback<V> callback) {
        useCaseScheduler.notifyError(callback);
    }

    private static final class UiCallback<V extends UseCase.Response> implements
            UseCase.Callback<V> {
        private final UseCase.Callback<V> callback;
        private final UseCaseHandler handler;

        UiCallback(UseCase.Callback<V> callback,
                   UseCaseHandler handler) {
            this.callback = callback;
            this.handler = handler;
        }

        @Override
        public void onSuccess(V response) {
            handler.notifySuccess(response, callback);
        }

        @Override
        public void onError() {
            handler.notifyError(callback);
        }
    }
}
