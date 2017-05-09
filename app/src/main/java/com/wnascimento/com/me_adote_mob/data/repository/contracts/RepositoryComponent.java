package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.data.repository.fake.RepositoryFakeModule;

import dagger.Component;

@Component(modules = RepositoryFakeModule.class)
public interface RepositoryComponent {

    IOwnerRepository getOwnerRepository();

    IPetRepository getPetRepository();

}
