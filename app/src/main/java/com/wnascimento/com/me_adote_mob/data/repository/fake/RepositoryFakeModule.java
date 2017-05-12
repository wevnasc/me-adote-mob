package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.IOwnerRepository;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.IPetRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryFakeModule {

    @Provides
    IOwnerRepository getOwnerFakeRepository() {
        return OwnerFakeRepository.getInstance();
    }

    @Provides
    IPetRepository getPetFakeRepository() {
        return PetFakeRepository.getInstance();
    }

}
