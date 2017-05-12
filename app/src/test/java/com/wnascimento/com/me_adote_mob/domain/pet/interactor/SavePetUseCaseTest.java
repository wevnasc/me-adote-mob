package com.wnascimento.com.me_adote_mob.domain.pet.interactor;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.ImmediateScheduler;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.domain.pet.PetMother;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class SavePetUseCaseTest {

    @ClassRule
    public static final ImmediateScheduler schedulers = new ImmediateScheduler();

    @Mock
    private IPetRepository petRepository;

    private SavePetUseCase savePetUseCase;

    @Before
    public void init() {
        initMocks(this);
        savePetUseCase = new SavePetUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(), petRepository);
    }

    @Test
    public void shouldReturnSuccessWhenSave() {

        when(petRepository.save(any(IPet.class)))
                .thenReturn(Completable.complete());

        TestObserver testObserver = TestObserver.create();
        savePetUseCase.run(new SavePetUseCase.Request(PetMother.getPet())).subscribe(testObserver);

        testObserver.assertNoErrors();
    }

}
