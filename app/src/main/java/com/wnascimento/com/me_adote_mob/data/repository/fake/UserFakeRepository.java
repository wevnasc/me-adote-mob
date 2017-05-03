package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.entity.UserEntity;
import com.wnascimento.com.me_adote_mob.data.mapper.UserMapper;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.login.model.Authenticable;
import com.wnascimento.com.me_adote_mob.domain.login.model.UnauthenticatedUser;
import com.wnascimento.com.me_adote_mob.domain.login.model.User;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class UserFakeRepository implements UserRepository {

    private static Map<String, UserEntity> userStruct = new HashMap<>();

    public UserFakeRepository() {
        createFakeStruct();
    }

    private void createFakeStruct() {
        for (int i = 0; i < 20; i++) {
            userStruct.put("" + i, new UserEntity("example" + i + "@a.com", "example" + i));
        }
    }

    @Override
    public Flowable<Authenticable> login(Authenticable user) {
        return Flowable.create(flowableEmitter -> {
            UserEntity userEntity = UserMapper.transform((User) user);
            try {
                if (userStruct.containsValue(userEntity)) {
                    flowableEmitter.onNext(user);
                } else {
                    flowableEmitter.onNext(new UnauthenticatedUser());
                }
                flowableEmitter.onComplete();
            } catch (Exception e) {
                flowableEmitter.onError(e);
            }
        }, BackpressureStrategy.BUFFER);

    }
}
