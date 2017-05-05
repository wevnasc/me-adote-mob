package com.wnascimento.com.me_adote_mob.domain.owner.model;

public interface Authenticable {

    String getEmail();

    String getPassword();

    boolean hasEmail();

    boolean hasPassword();

    boolean isLogged();

}
