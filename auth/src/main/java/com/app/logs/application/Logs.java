package com.app.logs.application;

import com.app.signUp.domain.event.UserCreated;

public class Logs {

    public void save(UserCreated data){
        System.out.printf("User signUp data  name: %s and email: %s",
                data.userName(),
                data.userEmail());;
    }
}
