package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.UnregisteredOwner;

import org.joda.time.LocalDate;

public class Pet implements PetContract {

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
    private OwnerContract owner;

    private Pet(PetBuilder petBuilder) {
        this.id = petBuilder.id == null ? "" : petBuilder.id;
        this.name = petBuilder.name;
        this.image = petBuilder.image;
        this.breed = petBuilder.breed;
        this.gender = petBuilder.gender;
        this.notes = petBuilder.notes;
        this.dateBirth = petBuilder.dateBirth;
        this.adopted = petBuilder.adopted;
        this.weight = petBuilder.weight;
        this.height = petBuilder.height;
        this.createdAt = petBuilder.createdAt == 0 ? LocalDate.now().toDate().getTime():  petBuilder.createdAt;
        this.owner = petBuilder.owner == null ? new UnregisteredOwner():  petBuilder.owner;
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
    public OwnerContract getOwner() {
        return owner;
    }

    @Override
    public void setOwner(OwnerContract owner) {
        this.owner = owner;
    }

    @Override
    public PetEntity toEntity() {
        return new PetEntity(id, name, image, breed, gender, notes,
                dateBirth,adopted,weight,height,createdAt,Long.parseLong(owner.getId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return id != null ? id.equals(pet.id) : pet.id == null;
    }

    public static class PetBuilder {
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
        private OwnerContract owner;

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

        public PetBuilder setOwner(OwnerContract owner) {
            this.owner = owner;
            return this;
        }

        public Pet build() {
            return new Pet(this);
        }
    }

}
