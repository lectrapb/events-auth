package com.app.signUp.application;

import com.app.signUp.domain.*;
import com.app.signUp.domain.value.object.Email;
import com.app.signUp.domain.value.object.Name;
import com.app.signUp.domain.value.object.Passsword;

public class MapperAuth {
    public static NewUser toEntity(UserSignUp req) {

        return  new NewUser(null, new Name(req.getName()),
                new Email(req.getEmail()), new Passsword(req.getPassword()));
    }
}
