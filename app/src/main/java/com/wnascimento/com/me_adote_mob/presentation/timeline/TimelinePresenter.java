package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.domain.pet.interactor.GetAvailablePetsUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TimelinePresenter implements TimelineContract.Presenter {

    private TimelineContract.View timelineView;
    private final GetAvailablePetsUseCase getAvailablePetsUseCase;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public TimelinePresenter(TimelineContract.View view, GetAvailablePetsUseCase getAvailablePetsUseCase) {
        timelineView = view;
        this.getAvailablePetsUseCase = getAvailablePetsUseCase;
        compositeDisposable = new CompositeDisposable();
        view.attachPresenter(this);
    }

    @Override
    public void reload() {
    }

    @Override
    public void close() {
        compositeDisposable.clear();
    }

    @Override
    public void getAvailablePets() {
        compositeDisposable.add(getAvailablePetsUseCase.run(new GetAvailablePetsUseCase.Request())
                .subscribe(timelineView::updateTimeline, e -> timelineView.showLoadError(), () -> {}));
    }
}
