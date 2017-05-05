package com.wnascimento.com.me_adote_mob.domain.owner.model;

public class Owner implements Authenticable {

    private final String id;
    private final String email;
    private final String password;
    private final String name;
    private final String image;

    public Owner(String id, String email, String password, String name, String image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean hasEmail() {
        return email != null && !email.isEmpty();
    }

    @Override
    public boolean hasPassword() {
        return password != null && !password.isEmpty();
    }

    @Override
    public boolean isLogged() {
        return hasEmail() && hasPassword();
    }

}
