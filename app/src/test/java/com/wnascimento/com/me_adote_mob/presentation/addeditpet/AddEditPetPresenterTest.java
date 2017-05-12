package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import com.wnascimento.com.me_adote_mob.domain.pet.PetMother;
import com.wnascimento.com.me_adote_mob.domain.pet.interactor.SavePetUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Completable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddEditPetPresenterTest {

    @Mock
    private SavePetUseCase savePetUseCase;

    @Mock
    private AddEditPetContract.View addEditPresenterView;

    private AddEditPetPresenter addEditPetPresenter;


    @Before
    public void init() {
        initMocks(this);
        addEditPetPresenter = new AddEditPetPresenter(addEditPresenterView, savePetUseCase);
    }

    @Test
    public void shouldSavePetGoToTimeline() {
        when(savePetUseCase.run(any(SavePetUseCase.Request.class)))
                .thenReturn(Completable.complete());

        addEditPetPresenter.savePet(PetMother.getPet());

        verify(savePetUseCase).run(any(SavePetUseCase.Request.class));
        verify(addEditPresenterView).goToTimeline();
    }

    @Test
    public void shouldSavePetShowErrorMessage() {
        when(savePetUseCase.run(any(SavePetUseCase.Request.class)))
                .thenReturn(Completable.error(new Exception("ERROR")));

        addEditPetPresenter.savePet(PetMother.getPet());

        verify(savePetUseCase).run(any(SavePetUseCase.Request.class));
        verify(addEditPresenterView).showMessageErrorSavePet();
    }
}
