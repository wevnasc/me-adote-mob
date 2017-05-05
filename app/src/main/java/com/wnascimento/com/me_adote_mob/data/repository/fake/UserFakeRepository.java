package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.owner.model.Authenticable;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;

public class UserFakeRepository implements UserRepository {

    private static Map<String, Authenticable> userStruct = new HashMap<>();

    public UserFakeRepository() {
        createFakeStruct();
    }

    private void createFakeStruct() {
        for (int i = 0; i < 20; i++) {
        }
    }

    @Override
    public Single<Authenticable> login(Authenticable user) {

        return Single.create(source -> {
        });

    }
}
