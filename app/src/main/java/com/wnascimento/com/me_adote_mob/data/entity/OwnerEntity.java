package com.wnascimento.com.me_adote_mob.data.entity;

import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;

import java.io.Serializable;

public class OwnerEntity implements Serializable {

    private String id;
    private String email;
    private String password;
    private String name;
    private String image;

    public OwnerEntity(String id, String email, String password, String name, String image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnerEntity that = (OwnerEntity) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    public OwnerContract toModel(){
        return new Owner(id, email, password, name, image);
    }
}
