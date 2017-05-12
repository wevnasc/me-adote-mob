package com.wnascimento.com.me_adote_mob.domain.owner;

import com.wnascimento.com.me_adote_mob.data.repository.fake.Struct;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class OwnerEntityModelTest {

    @Test
    public void shouldReturnEmailValid() throws Exception {
        OwnerContract owner = OwnerMother.getOwner();
        assertEquals("a@a.com", owner.getEmail());
    }

    @Test
    public void shouldReturnPasswordValid() throws Exception {
        OwnerContract owner = OwnerMother.getOwner();
        assertEquals("aaa", owner.getPassword());
    }

    @Test
    public void shouldReturnTrueIfHasEmail() throws Exception {
        OwnerContract owner = OwnerMother.getOwner();
        assertTrue(owner.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasEmail() throws Exception {
        OwnerContract owner = new UnregisteredOwner();
        assertFalse(owner.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasPassword() throws Exception {
        OwnerContract owner = new UnregisteredOwner();
        assertFalse(owner.hasPassword());
    }

    @Test
    public void shouldReturnTrueIfHasPassword() throws Exception {
        OwnerContract owner = Struct.getOwners().get("1").toModel();
        assertTrue(owner.hasPassword());
    }
}
