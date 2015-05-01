package com.nimbus.poc.events;

/**
 * Users of this library are expected to @Autowire in this interface type.
 *
 * Created by Kye on 30/04/15.
 */
public interface EventPublisher {

    void publish(Event event);
}
