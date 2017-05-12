package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.domain.pet.Pet;
import com.wnascimento.com.me_adote_mob.domain.pet.PetMother;
import com.wnascimento.com.me_adote_mob.domain.pet.interactor.GetAvailablePetsUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TimelinePresenterTest {

    @Mock
    private TimelineContract.View timelineView;

    @Mock
    private GetAvailablePetsUseCase getAvailablePetsUseCase;

    private TimelinePresenter timelinePresenter;

    @Before
    public void init() {
        initMocks(this);
        timelinePresenter = new TimelinePresenter(timelineView, getAvailablePetsUseCase);
    }

    @Test
    public void showAllAvailablePetsSuccess() {
        List<IPet> pets = Arrays.asList(PetMother.getPet(), PetMother.getPet());
        when(getAvailablePetsUseCase.run(any(GetAvailablePetsUseCase.Request.class))).thenReturn(Flowable.fromIterable(pets));

        timelinePresenter.getAvailablePets();

        verify(getAvailablePetsUseCase).run(any(GetAvailablePetsUseCase.Request.class));
        verify(timelineView, atMost(3)).updateTimeline(any(Pet.class));
    }

    @Test
    public void showAllAvailablePetsError() {
        when(getAvailablePetsUseCase.run(any(GetAvailablePetsUseCase.Request.class))).thenReturn(Flowable.error(new Exception("ERROR")));
        timelinePresenter.getAvailablePets();

        verify(getAvailablePetsUseCase).run(any(GetAvailablePetsUseCase.Request.class));
        verify(timelineView).showLoadError();
    }
}
