package com.wnascimento.autodoc.me_adote_mob.domain.adoption.entity;

public class Owner {

    private final String name;
    private final String login;
    private final String password;

    public Owner(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (login != null ? !login.equals(owner.login) : owner.login != null) return false;
        return password != null ? password.equals(owner.password) : owner.password == null;
    }
}
