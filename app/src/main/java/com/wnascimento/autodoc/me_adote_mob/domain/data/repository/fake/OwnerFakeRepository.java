package com.wnascimento.autodoc.me_adote_mob.domain.data.repository.fake;

import com.wnascimento.autodoc.me_adote_mob.domain.adoption.Executor;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.entity.Owner;
import com.wnascimento.autodoc.me_adote_mob.domain.data.repository.contracts.OwnerRepository;

import java.util.HashMap;
import java.util.Map;

public class OwnerFakeRepository implements OwnerRepository{

    private Map<String, Owner> ownerStruct = new HashMap<>();

    public OwnerFakeRepository() {
        createFakeStruct();
    }

    @Override
    public void login(String email, String password, Executor<Owner> executor) {
        Owner owner = new Owner("", email, password);
        if(ownerStruct.containsValue(owner)) {
            executor.onNext(owner);
            executor.completed();
        } else {
            executor.onError(new IllegalArgumentException("user not found!"));
        }
    }

    private void createFakeStruct() {
        this.ownerStruct.put("one", new Owner("John", "john@gmail.com", "jojo"));
    }
}
