package com.app.signUp.domain.event;

import com.app.domain.DomainEvent;



public record UserCreated(String userName, String userEmail) implements DomainEvent {

    private static final String FULL_QUALIFIED_EVENT_NAME = "app.auth.signup.event.1.user.created";

    @Override
    public String fullQualifiedEventName() {
        return FULL_QUALIFIED_EVENT_NAME;
    }
}
