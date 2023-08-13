package com.app.application;

import com.app.domain.DomainEventBus;
import com.app.signUp.domain.gateways.UserAuthRepository;
import com.app.signUp.application.SignUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SignUpTest {

    private UserAuthRepository userAuthRepository;
    private DomainEventBus eventBus;
    private SignUp useCase;

    @BeforeEach
    void setUp() {
        userAuthRepository = mock(UserAuthRepository.class);
        eventBus = mock(eventBus);
        useCase = new SignUp(userAuthRepository, eventBus);
    }

    @Test
    void save() {
        //given
        var req = com.app.signUp.domain.UserSignUp.builder()
                .name("")
                .email("")
                .password("")
                .build();
        //when
        doNothing().when(userAuthRepository).save(any());
        useCase.save(req);
        //Then
        verify(userAuthRepository, times(1));
    }


}