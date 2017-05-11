package com.wnascimento.com.me_adote_mob.presentation.addeditpet;


import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.domain.pet.interactor.SavePetUseCase;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AddEditPetPresenter implements AddEditPetContract.Presenter{

    private final AddEditPetContract.View addEditPetView;
    private final SavePetUseCase savePetUseCase;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public AddEditPetPresenter(AddEditPetContract.View addEditPetView, SavePetUseCase savePetUseCase) {
        this.addEditPetView = addEditPetView;
        this.savePetUseCase = savePetUseCase;
        compositeDisposable = new CompositeDisposable();
        addEditPetView.attachPresenter(this);
    }

    @Override
    public void reload() {
    }

    @Override
    public void close() {
        compositeDisposable.clear();
    }

    @Override
    public void savePet(IPet pet) {
        savePetUseCase.run(new SavePetUseCase.Request(pet)).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable disposable) {
                compositeDisposable.add(disposable);
            }

            @Override
            public void onComplete() {
                addEditPetView.goToTimeline();
            }

            @Override
            public void onError(Throwable throwable) {
                addEditPetView.showMessageErrorSavePet();
            }
        });
    }
}
