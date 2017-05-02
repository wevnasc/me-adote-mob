package com.wnascimento.com.me_adote_mob.data.repository.contracts;

import com.wnascimento.com.me_adote_mob.domain.login.entity.User;

public interface UserRepository {

    void login(User user, Executor<User> executor);

}
