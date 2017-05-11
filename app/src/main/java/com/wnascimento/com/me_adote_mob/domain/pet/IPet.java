package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.data.repository.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

public interface IPet {

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

    IOwner getOwner();

    void setOwner(IOwner owner);

    PetEntity toEntity();
}
