package com.wnascimento.com.me_adote_mob.presentation.addeditpet;

import com.wnascimento.com.me_adote_mob.MainComponent;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.RepositoryComponent;
import com.wnascimento.com.me_adote_mob.util.dagger.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {MainComponent.class, RepositoryComponent.class}, modules = {AddEditPetModule.class})
public interface AddEditPetComponent {

    void inject(AddEditPetActivity addEditPetActivity);

}
