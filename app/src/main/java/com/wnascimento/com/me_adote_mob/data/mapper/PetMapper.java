package com.wnascimento.com.me_adote_mob.data.mapper;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.pet.model.Pet;


public class PetMapper {

    public static Pet toTimelinePet(PetEntity petEntity) {
        return new Pet(petEntity.getId(), petEntity.getBreed(), petEntity.getImage(),
                petEntity.getBreed(),
                petEntity.getGender(), petEntity.getNotes(), petEntity.getDateBith(),
                petEntity.isAdopted(), petEntity.getWeight(), petEntity.getHeight(),
                petEntity.getCreatedAt(), OwnerMapper.toOwnerModel(petEntity.getOwnerEntity()));
    }
}
