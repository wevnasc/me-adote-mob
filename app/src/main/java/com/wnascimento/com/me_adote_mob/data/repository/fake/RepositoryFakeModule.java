package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contract.OwnerRepositoryContract;
import com.wnascimento.com.me_adote_mob.data.repository.contract.PetRepositoryContract;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryFakeModule {

    @Provides
    OwnerRepositoryContract getOwnerFakeRepository() {
        return OwnerFakeRepository.getInstance();
    }

    @Provides
    PetRepositoryContract getPetFakeRepository() {
        return PetFakeRepository.getInstance();
    }

}
