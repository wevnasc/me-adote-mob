package com.wnascimento.autodoc.me_adote_mob.domain.data.repository.contracts;

import com.wnascimento.autodoc.me_adote_mob.domain.adoption.Executor;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.entity.Owner;

public interface OwnerRepository {

    void login(String email, String password, Executor<Owner> executor);

}
