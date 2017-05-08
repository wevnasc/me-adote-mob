package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.pet.Pet;
import com.wnascimento.com.me_adote_mob.domain.pet.interactor.GetAvailablePetsUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
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
        when(getAvailablePetsUseCase.run(any(Params.class))).thenReturn(Flowable.fromIterable(getAvailablePets()));

        timelinePresenter.getAvailablePets();

        verify(getAvailablePetsUseCase).run(any(Params.class));
        verify(timelineView, atMost(3)).updateTimeline(any(Pet.class));
    }

    @Test
    public void showAllAvailablePetsError() {
        when(getAvailablePetsUseCase.run(any(Params.class))).thenReturn(Flowable.error(new Exception("ERROR")));
        timelinePresenter.getAvailablePets();

        verify(getAvailablePetsUseCase).run(any(Params.class));
        verify(timelineView).showLoadError();
    }

    private List<Pet> getAvailablePets() {
        List<Pet> pets = new ArrayList<>();
        return pets;
    }
}
