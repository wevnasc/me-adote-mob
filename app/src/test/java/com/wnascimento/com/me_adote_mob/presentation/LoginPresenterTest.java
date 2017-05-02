package com.wnascimento.com.me_adote_mob.presentation;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.Executor;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.login.entity.RegisteredUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.User;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginContract;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoginContract.View loginView;

    private LoginPresenter loginPresenter;

    @Captor
    private ArgumentCaptor<Executor<User>> executor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginOpenPetsSuccess() throws Exception {
        loginPresenter = (LoginPresenter) new LoginPresenterTestFactory().make(loginView, userRepository);

        User user = new RegisteredUser("EMAIL", "PASSWORD");
        loginPresenter.login(user.getEmail(), user.getPassword());

        verify(userRepository).login(eq(user), executor.capture());
        executor.getValue().onNext(user);

        verify(loginView).showPets();
    }

    @Test
    public void loginEmailEmptyShowMessageEmptyEmail() throws Exception {
        loginPresenter = (LoginPresenter) new LoginPresenterTestFactory().make(loginView, userRepository);

        loginPresenter.login("", "PASSWORD");
        verify(loginView).showMessageEmailNotValid();
    }

    @Test
    public void loginPasswordEmptyShowMessageEmptyPassword() throws Exception {
        loginPresenter = (LoginPresenter) new LoginPresenterTestFactory().make(loginView, userRepository);

        loginPresenter.login("EMAIL", "");
        verify(loginView).showMessagePasswordNotValid();
    }

    @Test
    public void loginShowMessageFail() throws Exception {
        loginPresenter = (LoginPresenter) new LoginPresenterTestFactory().make(loginView, userRepository);

        User user = new RegisteredUser("EMAIL", "PASSWORD");
        loginPresenter.login(user.getEmail(), user.getPassword());

        verify(userRepository).login(eq(user), executor.capture());
        executor.getValue().onError();

        verify(loginView).message(anyString());
    }

}
