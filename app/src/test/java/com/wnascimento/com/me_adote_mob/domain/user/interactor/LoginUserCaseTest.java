package com.wnascimento.com.me_adote_mob.domain.user.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.ImmediateScheduler;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.owner.interactor.LoginUserFlowableUseCase;
import com.wnascimento.com.me_adote_mob.domain.owner.model.Authenticable;
import com.wnascimento.com.me_adote_mob.domain.owner.model.UnauthenticatedOwner;
import com.wnascimento.com.me_adote_mob.domain.user.model.User;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginUserCaseTest {

    @ClassRule
    public static final ImmediateScheduler schedulers = new ImmediateScheduler();

    @Mock
    private UserRepository userRepository;
    private LoginUserFlowableUseCase loginUseCase;

    @Before
    public void init() {
        initMocks(this);
        loginUseCase = new LoginUserFlowableUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(), userRepository);
    }

    @Test
    public void shouldReturnUserNotFoundIfEmailAndPasswordNotFound() {
        TestObserver<Boolean> testObserver = TestObserver.create();
        Params params = Params.create();
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_EMAIL, "");
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_PASSWORD, "");

        Authenticable user = new UnauthenticatedOwner();
        when(userRepository.login(any(Authenticable.class))).thenReturn(Single.just(user));
        loginUseCase.run(params).subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValue(false);
    }

    @Test
    public void shouldReturnUserRegisteredIfUserFound() {
        TestObserver<Boolean> testObserver = TestObserver.create();
        Params params = Params.create();
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_EMAIL, "EMAIL");
        params.put(LoginUserFlowableUseCase.PARAMS_KEY_PASSWORD, "PASSWORD");

        Authenticable user = new User("EMAIL", "PASSWORD");
        when(userRepository.login(any(Authenticable.class))).thenReturn(Single.just(user));
        loginUseCase.run(params).subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValue(true);


    }


}
