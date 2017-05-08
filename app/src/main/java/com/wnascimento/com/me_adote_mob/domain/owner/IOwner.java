package com.wnascimento.com.me_adote_mob.domain.owner;

public interface IOwner {

    public String getId();

    public String getName();

    public String getImage();

    public String getEmail();

    public String getPassword();

    public boolean hasEmail();

    public boolean hasPassword();

    public boolean hasRegistred();

}
