package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

public class PetBuilder {
    private String id;
    private String name;
    private String image;
    private String breed;
    private int gender;
    private String notes;
    private long dateBirth;
    private boolean adopted;
    private double weight;
    private double height;
    private long createdAt;
    private IOwner owner;

    public PetBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder setImage(String image) {
        this.image = image;
        return this;
    }

    public PetBuilder setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public PetBuilder setGender(int gender) {
        this.gender = gender;
        return this;
    }

    public PetBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public PetBuilder setDateBirth(long dateBirth) {
        this.dateBirth = dateBirth;
        return this;
    }

    public PetBuilder setAdopted(boolean adopted) {
        this.adopted = adopted;
        return this;
    }

    public PetBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public PetBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    public PetBuilder setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public PetBuilder setOwner(IOwner owner) {
        this.owner = owner;
        return this;
    }

    public Pet build() {
        return new Pet(id, name, image, breed, gender, notes, dateBirth, adopted, weight, height, createdAt, owner);
    }
}