package com.wnascimento.com.me_adote_mob.domain.login.entity;

/**
 * Created by autodoc on 02/05/17.
 */

public interface User {
    String getEmail();

    String getPassword();

    boolean hasEmail();

    boolean hasPassword();

    boolean isLogged();
}
