package com.wnascimento.com.me_adote_mob.presentation.timeline;


import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface TimelineContract {

    interface View extends BaseView<Presenter> {

        void updateTimeline(IPet pet);

        void showLoadError();

    }

    interface Presenter extends BasePresenter {

        void getAvailablePets();

    }

}
