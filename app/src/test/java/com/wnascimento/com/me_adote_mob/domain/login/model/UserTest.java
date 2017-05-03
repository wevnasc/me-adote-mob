package com.wnascimento.com.me_adote_mob.domain.login.model;

import android.support.annotation.NonNull;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldReturnEmailValid() throws Exception {
        Authenticable user = getRegisteredUser();
        assertEquals("user@example.com", user.getEmail());
    }

    @Test
    public void shouldReturnPasswordValid() throws Exception {
        Authenticable user = getRegisteredUser();
        assertEquals("123456", user.getPassword());
    }

    @Test
    public void shouldReturnTrueIfHasEmail() throws Exception {
        Authenticable user = getRegisteredUser();
        assertTrue(user.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasEmail() throws Exception {
        Authenticable user = new User("", "");
        assertFalse(user.hasEmail());
    }

    @Test
    public void shouldReturnFalseIfNotHasPassword() throws Exception {
        Authenticable user = new User("", "");
        assertFalse(user.hasPassword());
    }

    @Test
    public void shouldReturnTrueIfHasPassword() throws Exception {
        Authenticable user = getRegisteredUser();
        assertTrue(user.hasPassword());
    }

    @NonNull
    private Authenticable getRegisteredUser() {
        return new User("user@example.com", "123456");
    }
}
