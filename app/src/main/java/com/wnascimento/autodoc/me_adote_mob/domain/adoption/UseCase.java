package com.wnascimento.autodoc.me_adote_mob.domain.adoption;

public abstract class UseCase<U, T> {

    public abstract void execute(U req, Executor<T> executor);

    public static class Request {
    }
}
