package com.wnascimento.com.me_adote_mob.domain.owner.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.domain.ImmediateScheduler;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

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
    private OwnerRepositoryContract ownerRepository;
    private LoginUserFlowableUseCase loginUseCase;

    @Before
    public void init() {
        initMocks(this);
        loginUseCase = new LoginUserFlowableUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(), ownerRepository);
    }

    @Test
    public void shouldReturnUserNotFoundIfEmailAndPasswordNotFound() {
        TestObserver<Boolean> testObserver = TestObserver.create();

        OwnerContract user = new UnregisteredOwner();
        when(ownerRepository.login(any(OwnerContract.class))).thenReturn(Single.just(user));
        loginUseCase.run(new LoginUserFlowableUseCase.Request(new UnregisteredOwner())).subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValue(false);
    }

    @Test
    public void shouldReturnUserRegisteredIfUserFound() {
        TestObserver<Boolean> testObserver = TestObserver.create();

        OwnerContract user = new Owner("EMAIL", "PASSWORD");
        when(ownerRepository.login(any(OwnerContract.class))).thenReturn(Single.just(user));
        loginUseCase.run(new LoginUserFlowableUseCase.Request(user)).subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValue(true);


    }


}
