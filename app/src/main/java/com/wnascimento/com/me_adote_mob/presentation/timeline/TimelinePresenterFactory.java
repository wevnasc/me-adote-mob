package com.wnascimento.com.me_adote_mob.presentation.timeline;


import com.wnascimento.com.me_adote_mob.data.repository.fake.PetFakeRepository;
import com.wnascimento.com.me_adote_mob.domain.timeline.interactor.GetAvailablePetsUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TimelinePresenterFactory {

    public static TimelineContract.Presenter make(TimelineContract.View view) {
        return new TimelinePresenter(view,
                new GetAvailablePetsUseCase(Schedulers.newThread(), AndroidSchedulers.mainThread(),
                        new PetFakeRepository()));
    }

}
