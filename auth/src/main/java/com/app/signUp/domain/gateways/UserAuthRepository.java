package com.app.signUp.domain.gateways;

import com.app.signUp.domain.NewUser;

public interface UserAuthRepository {

    void save(NewUser userAuth);
}
