package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import dagger.Module;
import dagger.Provides;

@Module
public class AddEditPetModule {

    private final AddEditPetContract.View view;

    public AddEditPetModule(AddEditPetContract.View view) {
        this.view = view;
    }

    @Provides
    public AddEditPetContract.View getView() {
        return view;
    }
}
