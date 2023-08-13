package com.app.domain;

import java.util.List;

public interface DomainEventBus {

    void publish(final List<DomainEvent> events);

}
