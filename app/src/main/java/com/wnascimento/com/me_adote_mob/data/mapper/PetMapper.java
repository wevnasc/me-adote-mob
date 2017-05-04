package com.wnascimento.com.me_adote_mob.data.mapper;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;


public class PetMapper {

    public static AvailablePet toAvailablePet(PetEntity petEntity) {
        return new AvailablePet(petEntity.getId(), petEntity.getName(), petEntity.getImage(), petEntity.getNotes(), petEntity.getCreatedAt());
    }
}
