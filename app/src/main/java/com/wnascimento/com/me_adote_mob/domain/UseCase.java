package com.wnascimento.com.me_adote_mob.domain;

public abstract class UseCase<T extends UseCase.Request, R extends UseCase.Response> {

    private UseCase.Callback callback;

    private T request;

    public void setRequest(T request) {
        this.request = request;
    }

    public Callback<R> getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void run() {
        execute(request);
    }

    protected abstract void execute(T req);

    public interface Request {
    }

    public interface Response {
    }

    public interface Callback<R> {
        void onSuccess(R response);

        void onError();
    }
}
