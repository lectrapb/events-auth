package com.app.domain;

@FunctionalInterface
public interface EventProcessor<T> {
    void process(T event);
}