package com.app.signUp.domain;

import com.app.domain.AggregateRoot;
import com.app.signUp.domain.event.UserCreated;
import com.app.signUp.domain.value.object.Email;
import com.app.signUp.domain.value.object.Name;
import com.app.signUp.domain.value.object.Passsword;
import lombok.Getter;

@Getter
public class NewUser extends AggregateRoot {

    private final Long id;
    private final Name name;
    private final Email email;
    private final Passsword passsword;

    public NewUser(Long id , Name name, Email email, Passsword passsword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passsword = passsword;
    }

    public static NewUser publish(Name userName, Email userEmail){
        var user = new NewUser(null, userName, userEmail, null);
        var userCreated = new UserCreated(userName.value(), userEmail.value());

        user.record(userCreated);
        return  user;
    }


}
