package com.wnascimento.com.me_adote_mob.domain.owner;

import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;

public class UnregisteredOwner implements OwnerContract {

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getImage() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean hasEmail() {
        return false;
    }

    @Override
    public boolean hasPassword() {
        return false;
    }

    @Override
    public boolean hasRegistred() {
        return false;
    }

    @Override
    public OwnerEntity toEntity() {
        return new OwnerEntity("","", "", "", "");
    }
}
