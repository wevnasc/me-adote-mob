package com.wnascimento.com.me_adote_mob.domain.owner;

import com.wnascimento.com.me_adote_mob.data.repository.fake.Struct;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class OwnerTest {

    @Test
    public void shouldReturnEmailValid() throws Exception {
        IOwner owner = OwnerMother.getOwner();
        assertEquals("a@a.com", owner.getEmail());
    }

    @Test
    public void shouldReturnPasswordValid() throws Exception {
        IOwner owner = OwnerMother.getOwner();
        assertEquals("aaa", owner.getPassword());
    }

    @Test
    public void shouldReturnTrueIfHasEmail() throws Exception {
        IOwner owner = OwnerMother.getOwner();
        assertTrue(owner.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasEmail() throws Exception {
        IOwner owner = new UnregisteredOwner();
        assertFalse(owner.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasPassword() throws Exception {
        IOwner owner = new UnregisteredOwner();
        assertFalse(owner.hasPassword());
    }

    @Test
    public void shouldReturnTrueIfHasPassword() throws Exception {
        IOwner owner = Struct.getOwners().get("1");
        assertTrue(owner.hasPassword());
    }
}
