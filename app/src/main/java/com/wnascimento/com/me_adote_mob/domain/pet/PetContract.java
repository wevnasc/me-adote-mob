package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;

public interface PetContract {

    int FEMALE = 1;
    int MALE = 2;

    String getId();

    String getName();

    String getImage();

    String getBreed();

    int getGender();

    long getDateBirth();

    boolean isAdopted();

    double getWeight();

    long getCreatedAt();

    OwnerContract getOwner();

    void setOwner(OwnerContract owner);

    PetEntity toEntity();
}
