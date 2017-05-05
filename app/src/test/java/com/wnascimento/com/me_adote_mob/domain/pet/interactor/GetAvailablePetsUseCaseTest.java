package com.wnascimento.com.me_adote_mob.domain.pet.interactor;


import com.wnascimento.com.me_adote_mob.data.repository.contracts.PetRepository;
import com.wnascimento.com.me_adote_mob.domain.ImmediateScheduler;
import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.pet.model.Pet;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
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
    private PetRepository petRepository;

    private GetAvailablePetsUseCase getAvailablePetsUseCase;

    @Before
    public void init() {
        initMocks(this);
        getAvailablePetsUseCase = new GetAvailablePetsUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(), petRepository);
    }

    @Test
    public void shouldReturnAllAvailablePetInOrderDescWithRandomDateCreated() {
        List<Pet> pets = new ArrayList<>();

        TestSubscriber<Pet> testSubscriber = new TestSubscriber<>();
        when(petRepository.getAvailablePets()).thenReturn(Flowable.fromIterable(pets));

        getAvailablePetsUseCase.run(Params.create()).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

    }
}
