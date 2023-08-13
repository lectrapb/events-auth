package com.app.application;

import com.app.domain.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {

    Class<EventType> subscribedTo();

    void consume(EventType event);

}
