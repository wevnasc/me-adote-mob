package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.entity.OwnerEntity;
import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.data.mapper.PetMapper;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.PetRepository;
import com.wnascimento.com.me_adote_mob.domain.pet.model.Pet;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;

public class PetFakeRepository implements PetRepository {

    private static Map<String, PetEntity> petStruct = new HashMap<>();

    public PetFakeRepository() {
        createFakeStruct();
    }

    private void createFakeStruct() {
        PetEntity pet1 = new PetEntity.Builder()
                .setId("1")
                .setName("Brutos asdasdasdasdasdasdasdasdadasdasd")
                .setAdopted(false)
                .setDateBirth(new Date().getTime())
                .setBreed("Pit bull")
                .setGender(0)
                .setHeight(1)
                .setWeight(1)
                .setImage("https://images-na.ssl-images-amazon.com/images/G/01/img15/pet-products/small-tiles/23695_pets_vertical_store_dogs_small_tile_8._CB312176604_.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(new Date().getTime())
                .setOwnerEntity(new OwnerEntity("1", "Wenik", "http://vignette3.wikia.nocookie.net/adventuretimewithfinnandjake/images/7/75/S4e7_smiling_Finn_n_BMO.jpg/revision/latest?cb=20120517173955"))
                .build();

        petStruct.put("1", pet1);


        PetEntity pet2 = new PetEntity.Builder()
                .setId("2")
                .setName("Marley")
                .setAdopted(false)
                .setCreatedAt(new Date().getTime())
                .setBreed("Pit bull")
                .setGender(1)
                .setHeight(2)
                .setWeight(2)
                .setImage("https://www.rover.com/blog/wp-content/uploads/2015/05/dog-candy-junk-food-599x340.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(new Date().getTime())
                .setOwnerEntity(new OwnerEntity("2", "Weverson", "http://vignette3.wikia.nocookie.net/adventuretimewithfinnandjake/images/7/75/S4e7_smiling_Finn_n_BMO.jpg/revision/latest?cb=20120517173955"))
                .build();

        petStruct.put("2", pet2);

        PetEntity pet3 = new PetEntity.Builder()
                .setId("3")
                .setName("Totó")
                .setAdopted(false)
                .setCreatedAt(new Date().getTime())
                .setBreed("Pit bull")
                .setGender(1)
                .setHeight(4)
                .setWeight(4)
                .setImage("https://www.bluecross.org.uk/sites/default/files/assets/images/20311lpr.jpg")
                .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                .setCreatedAt(new Date().getTime())
                .setOwnerEntity(new OwnerEntity("3", "Marineusa", "http://vignette3.wikia.nocookie.net/adventuretimewithfinnandjake/images/7/75/S4e7_smiling_Finn_n_BMO.jpg/revision/latest?cb=20120517173955"))
                .build();

        petStruct.put("3", pet3);

    }

    @Override
    public Flowable<Pet> getAvailablePets() {
        return Flowable.fromIterable(petStruct.values())
                .filter(pet -> !pet.isAdopted())
                .map(PetMapper::toTimelinePet);
    }

}
