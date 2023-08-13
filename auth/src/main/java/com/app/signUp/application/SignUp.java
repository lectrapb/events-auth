package com.app.signUp.application;

import com.app.domain.DomainEventBus;
import com.app.signUp.domain.NewUser;
import com.app.signUp.domain.UserSignUp;
import com.app.signUp.domain.gateways.UserAuthRepository;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class SignUp {

    private final UserAuthRepository userRepository;
    private final DomainEventBus bus;
    public void save(UserSignUp req){

        var user =  MapperAuth.toEntity(req);
        userRepository.save(user);

        final var userEvent =NewUser.publish(user.getName(), user.getEmail());
        bus.publish(userEvent.pullDomainEvents());

    }
}
