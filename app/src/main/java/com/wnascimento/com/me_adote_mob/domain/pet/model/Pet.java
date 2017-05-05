package com.wnascimento.com.me_adote_mob.domain.pet.model;

import com.wnascimento.com.me_adote_mob.domain.owner.model.Owner;

public class Pet {

    private final String id;
    private final String name;
    private final String image;
    private final String breed;
    private final int gender;
    private final String notes;
    private final long dateBirth;
    private final boolean adopted;
    private final double weight;
    private final double height;
    private final long createdAt;
    private final Owner owner;

    public Pet(String id, String name, String image, String breed, int gender, String notes,
               long dateBirth, boolean adopted, double weight, double height, long createdAt,
               Owner owner) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.breed = breed;
        this.gender = gender;
        this.notes = notes;
        this.dateBirth = dateBirth;
        this.adopted = adopted;
        this.weight = weight;
        this.height = height;
        this.createdAt = createdAt;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBreed() {
        return breed;
    }

    public int getGender() {
        return gender;
    }

    public long getDateBirth() {
        return dateBirth;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public double getWeight() {
        return weight;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet that = (Pet) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }
}
