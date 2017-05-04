package com.wnascimento.com.me_adote_mob.domain.timeline.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AvailablePetTest {

    @Test
    public void shouldReturnIdValid() throws Exception {
        AvailablePet pet = getAvailablePet();
        assertEquals("ID", pet.getId());
    }

    @Test
    public void shouldReturnNameValid() throws Exception {
        AvailablePet pet = getAvailablePet();
        assertEquals("NAME", pet.getName());
    }

    @Test
    public void shouldReturnImageValid() throws Exception {
        AvailablePet pet = getAvailablePet();
        assertEquals("IMAGE", pet.getImage());
    }

    @Test
    public void shouldReturnNotesValid() throws Exception {
        AvailablePet pet = getAvailablePet();
        assertEquals("NOTES", pet.getNotes());
    }

    @Test
    public void shouldReturnCreatedAtValid() throws Exception {
        AvailablePet pet = getAvailablePet();
        assertEquals(1493906510L, pet.getCreatedAt(), 0);
    }

    private AvailablePet getAvailablePet() {
        return new AvailablePet("ID", "NAME", "IMAGE", "NOTES", 1493906510L);
    }
}
