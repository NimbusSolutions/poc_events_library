package com.nimbus.poc.events;

/**
 * Users of this library are expected to create an implementation of this and annotate with @Component so it will be
 * registered and be notified when events occur.
 *
 * Created by Kye on 30/04/15.
 */
public interface EventSubscriber {

    void onEvent(Event event);
}
