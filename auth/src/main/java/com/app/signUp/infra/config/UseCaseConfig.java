package com.app.signUp.infra.config;

import com.app.domain.DomainEventBus;
import com.app.signUp.application.SignUp;
import com.app.signUp.domain.gateways.UserAuthRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SignUp signUp(UserAuthRepository userRepository,
                         DomainEventBus eventBus){
        return new SignUp(userRepository, eventBus);
    }

}
