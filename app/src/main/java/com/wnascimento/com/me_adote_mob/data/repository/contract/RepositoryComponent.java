package com.wnascimento.com.me_adote_mob.data.repository.contract;

import com.wnascimento.com.me_adote_mob.data.repository.fake.RepositoryFakeModule;

import dagger.Component;

@Component(modules = RepositoryFakeModule.class)
public interface RepositoryComponent {

    OwnerRepositoryContract getOwnerRepository();

    PetRepositoryContract getPetRepository();

}
