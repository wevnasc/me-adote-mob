package com.wnascimento.com.me_adote_mob.data.mapper;

import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.model.Owner;

public class OwnerMapper {

    public static Owner toOwnerModel(OwnerEntity ownerEntity) {
        return new Owner(ownerEntity.getId(), ownerEntity.getName(),
                ownerEntity.getImage(), ownerEntity.getEmail(), ownerEntity.getPassword());
    }

    public static OwnerEntity toOwnerEntity(Owner owner) {
        return new OwnerEntity(owner.getId(), owner.getName(), owner.getImage(),
                owner.getEmail(), owner.getPassword());
    }

}
