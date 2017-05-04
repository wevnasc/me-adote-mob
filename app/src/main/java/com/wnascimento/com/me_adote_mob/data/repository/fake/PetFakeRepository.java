package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.entity.PetEntity;
import com.wnascimento.com.me_adote_mob.data.mapper.PetMapper;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.PetRepository;
import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;

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
        for (int i = 1; i < 9; i++) {
            PetEntity pet = new PetEntity.Builder()
                    .setId(i + "")
                    .setName("My Pet " + i)
                    .setAdopted(false)
                    .setAge(i)
                    .setBreed("Pit bull")
                    .setGender("M")
                    .setHeight(i)
                    .setWeight(i)
                    .setImage("http://lorempicsum.com/futurama/627/300/" + i)
                    .setNotes("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend dolor in purus consequat dictum. Morbi sed dui vel metus.")
                    .setCreatedAt(new Date().getTime())
                    .build();

            petStruct.put("" + i, pet);

        }
    }

    @Override
    public Flowable<AvailablePet> getAvailablePets() {
        return Flowable.fromIterable(petStruct.values())
                .filter(pet -> !pet.isAdopted())
                .map(PetMapper::toAvailablePet);
    }

}
