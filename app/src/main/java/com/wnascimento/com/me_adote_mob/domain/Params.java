package com.wnascimento.com.me_adote_mob.domain;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Params {

    private final Map<String, Object> parameters = new HashMap<>();

    private Params() {
    }

    public static Params create() {
        return new Params();
    }

    public void put(@NonNull String key, @NonNull Object value) {
        parameters.put(key, value);
    }

    public String getString(@NonNull String key, @NonNull String defaultValue) {
        Object value = parameters.get(key);
        if (value == null) {
            return defaultValue;
        }
        try {
            return (String) value;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public Object get(@NonNull String key, @NonNull Object defaultValue) {
        Object value = parameters.get(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

}
