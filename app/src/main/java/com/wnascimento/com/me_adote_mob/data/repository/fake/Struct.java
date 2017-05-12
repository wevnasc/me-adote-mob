package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.data.repository.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.domain.pet.IPet;

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
                "Brutos",
                "https://www.cesarsway.com/sites/newcesarsway/files/styles/large_article_preview/public/Common-dog-behaviors-explained.jpg?itok=FSzwbBoi",
                "vira lata",
                IPet.MALE,
                "",
                Calendar.getInstance().getTimeInMillis(),
                false,
                1,
                1,
                Calendar.getInstance().getTimeInMillis(),
                "1"));

        petStruct.put("2", new PetEntity("2",
                "Scoob",
                "http://www.hillspet.com/HillsPetUS/v1/portal/en/us/cat-care/images/HP_PCC_md_0130_cat53.jpg",
                "vira lata",
                IPet.MALE,
                "",
                Calendar.getInstance().getTimeInMillis(),
                false,
                1,
                1,
                Calendar.getInstance().getTimeInMillis(),
                "1"));

        return petStruct;
    }
}
