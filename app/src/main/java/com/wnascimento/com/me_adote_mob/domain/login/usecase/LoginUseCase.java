package com.wnascimento.com.me_adote_mob.domain.login.usecase;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.Executor;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.UseCase;
import com.wnascimento.com.me_adote_mob.domain.login.entity.User;

public class LoginUseCase extends UseCase<LoginUseCase.Request, LoginUseCase.Response> {

    private final UserRepository userRepository;

    public LoginUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void execute(final Request req) {
        userRepository.login(req.getUser(), new Executor<User>() {
            @Override
            public void onNext(User user) {
                if (user.isLogged()) {
                    getCallback().onSuccess(new Response(user));
                } else {
                    getCallback().onError();
                }
            }

            @Override
            public void onError() {
                getCallback().onError();
            }

        });
    }

    public static final class Request implements UseCase.Request {
        private final User user;

        public Request(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }

    public static final class Response implements UseCase.Response {

        private final User user;

        public Response(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
