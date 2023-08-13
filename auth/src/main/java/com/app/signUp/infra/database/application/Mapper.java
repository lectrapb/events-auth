package com.app.signUp.infra.database.application;

import com.app.signUp.domain.NewUser;
import com.app.signUp.infra.database.domain.UserAuthData;

public class Mapper {
    public static UserAuthData toData(NewUser newUser) {

            return UserAuthData.builder()
                    .name(newUser.getName().value())
                    .password(newUser.getPasssword().value())
                    .email(newUser.getEmail().value())
                    .build();
    }
}
