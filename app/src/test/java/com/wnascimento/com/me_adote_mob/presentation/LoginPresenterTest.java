package com.wnascimento.com.me_adote_mob.presentation;

import com.wnascimento.com.me_adote_mob.domain.Params;
import com.wnascimento.com.me_adote_mob.domain.login.interactor.LoginUserUseCase;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginContract;
import com.wnascimento.com.me_adote_mob.presentation.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Flowable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginPresenterTest {

    @Mock
    private LoginUserUseCase loginUserUseCase;

    @Mock
    private LoginContract.View loginView;

    private LoginPresenter loginPresenter;


    @Before
    public void init() {
        initMocks(this);
        loginPresenter = (LoginPresenter) new LoginPresenterTestFactory().make(loginView, loginUserUseCase);
    }

    @Test
    public void loginOpenPetsSuccess() throws Exception {

        when(loginUserUseCase.run(any(Params.class)))
                .thenReturn(Flowable.just(true));

        loginPresenter.login("EMAIL", "PASSWORD");

        verify(loginUserUseCase).run(any(Params.class));
        verify(loginView).goToPets();
    }

    @Test
    public void loginEmailEmptyShowMessageEmptyEmail() throws Exception {

        loginPresenter.login("", "PASSWORD");
        verify(loginView).showMessageEmailNotValid();
    }

    @Test
    public void loginPasswordEmptyShowMessageEmptyPassword() throws Exception {

        loginPresenter.login("EMAIL", "");
        verify(loginView).showMessagePasswordNotValid();
    }

    @Test
    public void loginShowMessageFail() throws Exception {
        when(loginUserUseCase.run(any(Params.class)))
                .thenReturn(Flowable.error(new Exception("ERROR")));

        loginPresenter.login("EMAIL", "PASSWORD");

        verify(loginUserUseCase).run(any(Params.class));
        verify(loginView).showMessageUserNotFound();
    }

}
