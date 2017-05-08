package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

public interface IPet {

    int MALE = 1;
    int FEMALE = 0;

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
}
