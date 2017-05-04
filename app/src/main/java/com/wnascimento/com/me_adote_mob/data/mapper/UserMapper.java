package com.wnascimento.com.me_adote_mob.data.mapper;

import com.wnascimento.com.me_adote_mob.data.entity.UserEntity;
import com.wnascimento.com.me_adote_mob.domain.login.model.User;

public class UserMapper {

    public static UserEntity toUser(User user) {
        return new UserEntity(user.getEmail(), user.getPassword());
    }

}
