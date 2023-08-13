package com.app.shared.application;

import com.app.application.DomainEventSubscriber;
import com.app.logs.application.Logs;
import com.app.signUp.domain.event.UserCreated;

public class SendPushToSubscribersOnNewUserPublished implements DomainEventSubscriber<UserCreated> {
    @Override
    public Class<UserCreated> subscribedTo() {
        return UserCreated.class;
    }

    @Override
    public void consume(UserCreated event) {

         var logs = new Logs();
         logs.save(event);
    }
}
