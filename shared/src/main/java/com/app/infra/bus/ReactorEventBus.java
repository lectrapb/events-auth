package com.app.infra.bus;

import com.app.application.DomainEventSubscriber;
import com.app.domain.DomainEvent;
import com.app.domain.DomainEventBus;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.bus.selector.Selector;
import reactor.fn.Consumer;

import java.util.List;
import java.util.Set;

import static reactor.bus.selector.Selectors.$;

public class ReactorEventBus implements DomainEventBus {

    private  EventBus bus;

    public ReactorEventBus(Set<DomainEventSubscriber> subscribers) {
        this.bus= EventBus.create();
        subscribers.forEach(this::registerOnEventBus);
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }


    private void publish(DomainEvent event) {
        Class<? extends DomainEvent> eventIdentifier = event.getClass();
        Event<DomainEvent> wrappedEvent = Event.wrap(event);

        bus.notify(eventIdentifier, wrappedEvent);
    }

    private void registerOnEventBus(DomainEventSubscriber subscriber) {
        Selector eventIdentifier = $(subscriber.subscribedTo());
        bus.on(eventIdentifier, eventConsumer(subscriber));
    }

    private Consumer<Event> eventConsumer(final DomainEventSubscriber subscriber) {
        return (Event reactorEvent) -> {
            DomainEvent unwrappedEvent = (DomainEvent) reactorEvent.getData();
            subscriber.consume(unwrappedEvent);
        };
    }
}
