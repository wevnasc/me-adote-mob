package com.wnascimento.com.me_adote_mob.domain.login.entity;

/**
 * Created by autodoc on 02/05/17.
 */

public class NotFoundUser implements User {
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
    public boolean isLogged() {
        return false;
    }
}
