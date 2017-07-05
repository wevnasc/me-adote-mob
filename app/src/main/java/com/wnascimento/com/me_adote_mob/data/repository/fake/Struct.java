package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Struct {

    public static Map<String, OwnerEntity> getOwners() {
        Map<String, OwnerEntity> ownerStruct = new HashMap<>();
        ownerStruct.put("1", new OwnerEntity("1", "a@a.com", "aaa",
                "scarlett johansson",
                "http://coolspotters.com/files/photos/1109436/scarlett-johansson-profile.png?1381189248"));
        return ownerStruct;
    }

    public static Map<String, PetEntity> getPets() {
        Map<String, PetEntity> petStruct = new HashMap<>();
        petStruct.put("1", new PetEntity("1",
                "Bidu",
                "https://static.pexels.com/photos/33053/dog-young-dog-small-dog-maltese.jpg",
                "Shih-tzu",
                PetContract.MALE,
                "",
                Calendar.getInstance().getTimeInMillis(),
                false,
                0.5,
                0.3,
                Calendar.getInstance().getTimeInMillis(),
                1));

        petStruct.put("2", new PetEntity("2",
                "Conan",
                "http://animais.culturamix.com/blog/wp-content/uploads/2009/08/Pitbull-600x436.jpg",
                "Pitbull",
                PetContract.MALE,
                "",
                Calendar.getInstance().getTimeInMillis(),
                false,
                4,
                1.2,
                Calendar.getInstance().getTimeInMillis(),
                1));

        petStruct.put("3", new PetEntity("2",
                "Doris",
                "http://www.readersdigest.ca/wp-content/uploads/2011/01/4-ways-cheer-up-depressed-cat.jpg",
                "Ragdoll",
                PetContract.FEMALE,
                "",
                Calendar.getInstance().getTimeInMillis(),
                false,
                0.5,
                0.5,
                Calendar.getInstance().getTimeInMillis(),
                1));

        return petStruct;
    }
}
