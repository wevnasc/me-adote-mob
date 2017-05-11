package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.data.repository.retrofit.RepositoryRetrofitModule;

import dagger.Component;

@Component(modules = RepositoryRetrofitModule.class)
public interface RepositoryComponent {

    IOwnerRepository getOwnerRepository();

    IPetRepository getPetRepository();

}
