package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;

public class Pet implements IPet {

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
    private final IOwner owner;

    public Pet(String id, String name, String image, String breed, int gender, String notes,
               long dateBirth, boolean adopted, double weight, double height, long createdAt,
               IOwner owner) {
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public int getGender() {
        return gender;
    }

    @Override
    public long getDateBirth() {
        return dateBirth;
    }

    @Override
    public boolean isAdopted() {
        return adopted;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public IOwner getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return id != null ? id.equals(pet.id) : pet.id == null;
    }
}
