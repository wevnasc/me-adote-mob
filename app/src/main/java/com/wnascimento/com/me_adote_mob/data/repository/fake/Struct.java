package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.domain.owner.IOwner;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;
import com.wnascimento.com.me_adote_mob.domain.pet.Pet;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Struct {

    public static Map<String, IOwner> getOwners() {
        Map<String, IOwner> ownerStruct = new HashMap<>();
        ownerStruct.put("1", new Owner("1", "a@a.com", "aaa",
                "scarlett johansson",
                "http://coolspotters.com/files/photos/1109436/scarlett-johansson-profile.png?1381189248"));
        return ownerStruct;
    }

    public static Map<String, IPet> getPets() {
        Calendar createdAt = Calendar.getInstance();
        createdAt.set(2017, 5, 1);

        Calendar dateBirth = Calendar.getInstance();
        dateBirth.set(2016, 4, 8);


        Map<String, IPet> petStruct = new HashMap<>();
        IPet pet1 = new Pet.PetBuilder()
                .setId("1")
                .setName("Brutos")
                .setAdopted(false)
                .setDateBirth(dateBirth.getTimeInMillis())
                .setBreed("Pit bull")
                .setGender(Pet.MALE)
                .setHeight(1)
                .setWeight(1)
                .setImage("https://www.cesarsway.com/sites/newcesarsway/files/styles/large_article_preview/public/Common-dog-behaviors-explained.jpg?itok=FSzwbBoi")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(createdAt.getTimeInMillis())
                .setOwner(Struct.getOwners().get("1"))
                .build();

        petStruct.put("1", pet1);

        IPet pet2 = new Pet.PetBuilder()
                .setId("2")
                .setName("Zinha")
                .setAdopted(false)
                .setDateBirth(dateBirth.getTimeInMillis())
                .setBreed("Pit bull")
                .setGender(Pet.FEMALE)
                .setHeight(1)
                .setWeight(1)
                .setImage("http://thedailypositive.com/wp-content/uploads/2014/03/shutterstock_141945928.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(createdAt.getTimeInMillis())
                .setOwner(Struct.getOwners().get("1"))
                .build();

        petStruct.put("2", pet2);
        return petStruct;
    }
}
