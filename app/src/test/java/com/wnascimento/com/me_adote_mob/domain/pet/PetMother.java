package com.wnascimento.com.me_adote_mob.domain.pet;

import com.wnascimento.com.me_adote_mob.data.repository.fake.Struct;

import java.util.Date;

public class PetMother {

    public static IPet getPet(String id, long createdAt) {
        return new Pet.PetBuilder()
                .setId(id)
                .setName("Brutos")
                .setAdopted(false)
                .setDateBirth(new Date().getTime())
                .setBreed("Pit bull")
                .setGender(Pet.MALE)
                .setHeight(1)
                .setWeight(1)
                .setImage("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/23695_pets_vertical_store_dogs_small_tile_8._CB312176604_.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(createdAt)
                .setOwner(Struct.getOwners().get("1"))
                .build();
    }

    public static IPet getPet(long dateBirth) {
        return new Pet.PetBuilder()
                .setId("1")
                .setName("Brutos")
                .setAdopted(false)
                .setDateBirth(dateBirth)
                .setBreed("Pit bull")
                .setGender(Pet.MALE)
                .setHeight(1)
                .setWeight(1)
                .setImage("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/23695_pets_vertical_store_dogs_small_tile_8._CB312176604_.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(new Date().getTime())
                .setOwner(Struct.getOwners().get("1"))
                .build();
    }

    public static IPet getPet() {
        return new Pet.PetBuilder()
                .setId("1")
                .setName("Brutos")
                .setAdopted(false)
                .setDateBirth(new Date().getTime())
                .setBreed("Pit bull")
                .setGender(Pet.MALE)
                .setHeight(1)
                .setWeight(1)
                .setImage("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/23695_pets_vertical_store_dogs_small_tile_8._CB312176604_.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(new Date().getTime())
                .setOwner(Struct.getOwners().get("1"))
                .build();
    }

}
