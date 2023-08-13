package com.app.shared;

import com.app.domain.DomainEventBus;
import com.app.infra.bus.GuavaEventBus;
import com.app.shared.application.SendPushToSubscribersOnNewUserPublished;
import com.app.signUp.domain.event.UserCreated;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {



    @Bean
    public DomainEventBus domainEventBus(){
        var subscriber = new SendPushToSubscribersOnNewUserPublished();
        var bus = new EventBus();
        var eventBus = new GuavaEventBus(bus);
        eventBus.registerListener( UserCreated.class, subscriber::consume);
        return eventBus;

    }


}
