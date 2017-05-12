package com.wnascimento.com.me_adote_mob.presentation.addeditpet;


import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface AddEditPetContract {

    interface Presenter extends BasePresenter {
        void savePet(PetContract pet);
    }

    interface View extends BaseView<Presenter> {
        void goToTimeline();
        void showMessageErrorSavePet();
    }

}
