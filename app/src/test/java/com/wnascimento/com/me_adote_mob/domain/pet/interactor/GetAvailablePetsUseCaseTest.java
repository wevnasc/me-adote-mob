package com.wnascimento.com.me_adote_mob.domain.pet.interactor;


import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;
import com.wnascimento.com.me_adote_mob.domain.ImmediateScheduler;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.domain.pet.PetMother;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GetAvailablePetsUseCaseTest {

    @ClassRule
    public static final ImmediateScheduler schedulers = new ImmediateScheduler();

    @Mock
    private IPetRepository petRepository;

    private GetAvailablePetsUseCase getAvailablePetsUseCase;

    @Before
    public void init() {
        initMocks(this);
        getAvailablePetsUseCase = new GetAvailablePetsUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(), petRepository);
    }

    @Test
    public void shouldReturnAllAvailablePetInOrderDescWithRandomDateCreated() {
        IPet pet1 = PetMother.getPet("1", 1494253426);
        IPet pet2 = PetMother.getPet("2", 1494253435);
        IPet pet3 = PetMother.getPet("3", 1494253443);
        List<IPet> pets = Arrays.asList(pet1, pet2, pet3);

        TestSubscriber<IPet> testSubscriber = new TestSubscriber<>();
        when(petRepository.getAvailablePets()).thenReturn(Flowable.fromIterable(pets));

        getAvailablePetsUseCase.run(new GetAvailablePetsUseCase.Request()).subscribe(testSubscriber);

        testSubscriber.assertValueSequence(Arrays.asList(pet1, pet2, pet3));
        testSubscriber.assertNoErrors();

    }


}
