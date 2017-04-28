package com.wnascimento.autodoc.me_adote_mob.domain.adoption.usecase;

import com.wnascimento.autodoc.me_adote_mob.domain.adoption.Executor;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.UseCase;
import com.wnascimento.autodoc.me_adote_mob.domain.adoption.entity.Owner;
import com.wnascimento.autodoc.me_adote_mob.domain.data.repository.contracts.OwnerRepository;

public class ValidateCredentialsUseCase extends UseCase<ValidateCredentialsUseCase.Request, Owner> implements Executor<Owner> {

    private final OwnerRepository ownerRepository;

    public ValidateCredentialsUseCase(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void execute(Request req, final Executor<Owner> executor) {
        ownerRepository.login(req.getEmail(), req.getPassword(), new Executor<Owner>() {
            @Override
            public void onNext(Owner value) {
                executor.onNext(value);
            }

            @Override
            public void onError(Throwable error) {
                executor.onError(error);
            }

            @Override
            public void completed() {
                executor.completed();
            }
        });
    }

    @Override
    public void onNext(Owner value) {

    }

    @Override
    public void onError(Throwable error) {

    }

    @Override
    public void completed() {

    }

    public static final class Request extends UseCase.Request {

        private final String email;
        private final String password;

        public Request(String email, String password) {
            this.email = email;
            this.password = password;
        }


        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
