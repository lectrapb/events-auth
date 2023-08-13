package com.app.infra.bus;

import com.app.domain.*;
import com.google.common.eventbus.EventBus;

import java.util.List;

public class GuavaEventBus  implements DomainEventBus {

    private final EventBus eventBus;

    public  GuavaEventBus (EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.register(this);
    }

    public <T> void registerListener(Class<T> eventType, EventProcessor<T> eventProcessor) {
        eventBus.register(new EventListener<>(eventProcessor));
    }

    public void postEvent(Object event) {
        eventBus.post(event);
    }


    @Override
    public void publish(List<DomainEvent> events) {
         events.forEach(domainEvent -> {
             postEvent(domainEvent);
             System.out.printf("Event data published  %s ",
                     domainEvent.fullQualifiedEventName());
         });

    }
}
