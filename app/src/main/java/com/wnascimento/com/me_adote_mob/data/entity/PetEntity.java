package com.wnascimento.com.me_adote_mob.data.entity;

public class PetEntity {

    private String id;
    private String name;
    private String image;
    private String breed;
    private String gender;
    private String notes;
    private int age;
    private boolean adopted;
    private double weight;
    private double height;
    private long createdAt;


    public PetEntity(String id, String name, String image, String breed, String gender,
                     String notes, int age, boolean adopted, double weight, double height,
                     long createdAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.breed = breed;
        this.gender = gender;
        this.notes = notes;
        this.age = age;
        this.adopted = adopted;
        this.weight = weight;
        this.height = height;
        this.createdAt = createdAt;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public static class Builder {

        private String id;
        private String image;
        private String name;
        private String breed;
        private String gender;
        private String notes;
        private int age;
        private boolean adopted;
        private double weight;
        private double height;
        private long createdAt;

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

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
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

        public PetEntity build() {
            return new PetEntity(this.id, this.name, this.image, this.breed, this.gender,
                    this.notes, this.age, this.adopted, this.weight, this.height, this.createdAt);
        }

    }
}
