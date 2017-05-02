package com.wnascimento.com.me_adote_mob.domain.login.usecase;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.data.repository.fake.UserFakeRepository;
import com.wnascimento.com.me_adote_mob.domain.TestUseCaseScheduler;
import com.wnascimento.com.me_adote_mob.domain.UseCase;
import com.wnascimento.com.me_adote_mob.domain.UseCaseHandler;
import com.wnascimento.com.me_adote_mob.domain.login.entity.NotFoundUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.RegisteredUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.User;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class LoginUserCaseTest {

    private UserRepository userRepository;
    private UseCaseHandler handler;
    private LoginUseCase loginUseCase;

    @Before
    public void init() {
        userRepository = new UserFakeRepository();
        handler = UseCaseHandler.getInstance(new TestUseCaseScheduler());
        loginUseCase = new LoginUseCase(userRepository);
    }

    @Test
    public void shouldReturnUserNotFoundIfEmailAndPasswordNotFound() {
        User user = new RegisteredUser("test", "test");
        handler.execute(loginUseCase, new LoginUseCase.Request(user), new UseCase.Callback<LoginUseCase.Response>() {
            @Override
            public void onSuccess(LoginUseCase.Response response) {
                assertThat(response.getUser(), instanceOf(NotFoundUser.class));
            }

            @Override
            public void onError() {

            }
        });
    }

    @Test
    public void shouldReturnUserRegisteredIfUserFound() {
        User user = UserFakeRepository.getUserStruct().get("1");
        handler.execute(loginUseCase, new LoginUseCase.Request(user), new UseCase.Callback<LoginUseCase.Response>() {
            @Override
            public void onSuccess(LoginUseCase.Response response) {
                assertThat(response.getUser(), instanceOf(RegisteredUser.class));
            }

            @Override
            public void onError() {

            }
        });
    }


}
