package com.wnascimento.com.me_adote_mob.domain.login.entity;

import android.support.annotation.NonNull;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class RegisteredUserTest {

    @Test
    public void shouldReturnEmailValid() throws Exception {
        User user = getRegisteredUser();
        assertEquals("user@example.com", user.getEmail());
    }

    @Test
    public void shouldReturnPasswordValid() throws Exception {
        User user = getRegisteredUser();
        assertEquals("123456", user.getPassword());
    }

    @Test
    public void shouldReturnTrueIfHasEmail() throws Exception {
        User user = getRegisteredUser();
        assertTrue(user.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasEmail() throws Exception {
        User user = new RegisteredUser("", "");
        assertFalse(user.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasPassword() throws Exception {
        User user = new RegisteredUser("", "");
        assertFalse(user.hasPassword());
    }

    @Test
    public void shouldReturnTrueIfHasPassword() throws Exception {
        User user = getRegisteredUser();
        assertTrue(user.hasPassword());
    }

    @NonNull
    private User getRegisteredUser() {
        return new RegisteredUser("user@example.com", "123456");
    }
}
