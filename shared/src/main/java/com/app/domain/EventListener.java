package com.app.domain;

import com.google.common.eventbus.Subscribe;


public class EventListener<T> {
    private final EventProcessor<T> eventProcessor;

    public EventListener(EventProcessor<T> eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Subscribe
    public void handleEvent(T event) {
        eventProcessor.process(event);
    }
}
