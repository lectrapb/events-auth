package com.app.signUp.infra.database.application;

import com.app.signUp.domain.NewUser;
import com.app.signUp.domain.gateways.UserAuthRepository;
import com.app.signUp.infra.database.infra.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSignUpAdapter implements UserAuthRepository {

    private final UserRepository repository;
    @Override
    public void save(NewUser userAuth) {

         repository.save(Mapper.toData(userAuth));
    }
}
