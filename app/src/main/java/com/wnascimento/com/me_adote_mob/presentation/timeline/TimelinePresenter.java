package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.domain.contract.Params;
import com.wnascimento.com.me_adote_mob.domain.pet.interactor.GetAvailablePetsUseCase;

import io.reactivex.disposables.CompositeDisposable;

public class TimelinePresenter implements TimelineContract.Presenter {

    private final TimelineContract.View timelineView;
    private final GetAvailablePetsUseCase getAvailablePetsUseCase;
    private CompositeDisposable compositeDisposable;

    public TimelinePresenter(TimelineContract.View timelineView, GetAvailablePetsUseCase getAvailablePetsUseCase) {
        this.timelineView = timelineView;
        this.getAvailablePetsUseCase = getAvailablePetsUseCase;

        timelineView.attachPresenter(this);
        compositeDisposable = new CompositeDisposable();
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
        compositeDisposable.add(getAvailablePetsUseCase.run(Params.create())
                .subscribe(timelineView::updateTimeline, e -> {
                    timelineView.showLoadError();
                }, () -> {
                }));
    }
}
