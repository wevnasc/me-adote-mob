package com.wnascimento.com.me_adote_mob.data.repository.fake;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.Executor;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.UserRepository;
import com.wnascimento.com.me_adote_mob.domain.login.entity.NotFoundUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.RegisteredUser;
import com.wnascimento.com.me_adote_mob.domain.login.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserFakeRepository implements UserRepository {

    private static Map<String, User> userStruct = new HashMap<>();

    public UserFakeRepository() {
        createFakeStruct();
    }

    private static void createFakeStruct() {
        userStruct.put("1", new RegisteredUser("john@gmail.com", "jojo"));
    }

    public static Map<String, User> getUserStruct() {
        return userStruct;
    }

    @Override
    public void login(User user, Executor<User> executor) {
        try {
            if (userStruct.containsValue(user)) {
                executor.onNext(user);
            } else {
                executor.onNext(new NotFoundUser());
            }
        } catch (Exception e) {
            executor.onError();
        }

    }
}
