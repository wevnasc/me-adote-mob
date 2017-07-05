package com.wnascimento.com.me_adote_mob.presentation.timeline;


import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface TimelineContract {

    interface View extends BaseView<Presenter> {

        void updateTimeline(PetContract pet);

        void showLoadError();

        void cleanTimeline();

    }

    interface Presenter extends BasePresenter {

        void getAvailablePets();

    }

}
