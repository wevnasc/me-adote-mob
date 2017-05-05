package com.wnascimento.com.me_adote_mob.data.entity;

public class PetEntity {

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
    private OwnerEntity ownerEntity;


    public PetEntity(String id, String name, String image, String breed, int gender,
                     String notes, long dateBirth, boolean adopted, double weight,
                     double height, long createdAt, OwnerEntity ownerEntity) {
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
        this.ownerEntity = ownerEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getDateBith() {
        return dateBirth;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getDateBirth() {
        return dateBirth;
    }

    public PetEntity setDateBirth(long dateBirth) {
        this.dateBirth = dateBirth;
        return this;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public PetEntity setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
        return this;
    }

    public static class Builder {

        private String id;
        private String image;
        private String name;
        private String breed;
        private int gender;
        private String notes;
        private long dateBirth;
        private boolean adopted;
        private double weight;
        private double height;
        private long createdAt;
        private OwnerEntity ownerEntity;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setDateBirth(long dateBirth) {
            this.dateBirth = dateBirth;
            return this;
        }

        public Builder setAdopted(boolean adopted) {
            this.adopted = adopted;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setOwnerEntity(OwnerEntity ownerEntity) {
            this.ownerEntity = ownerEntity;
            return this;
        }

        public PetEntity build() {
            return new PetEntity(this.id, this.name, this.image, this.breed, this.gender,
                    this.notes, this.dateBirth, this.adopted, this.weight, this.height, this.createdAt, ownerEntity);
        }

    }
}
