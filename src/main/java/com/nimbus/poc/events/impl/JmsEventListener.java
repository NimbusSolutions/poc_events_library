package com.nimbus.poc.events.impl;

import com.nimbus.poc.events.Event;
import com.nimbus.poc.events.EventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Kye on 30/04/15.
 */
@Component
public class JmsEventListener {

    @Autowired(required = false)
    private List<EventSubscriber> listeners;

    @JmsListener(destination = "microservice.event", containerFactory = "topicJmsContainerFactory")
    public void receiveMessage(String message) {

        Event e = new Event();
        e.setMessage(message);

        System.out.println("Library received JMS message: " + e);
        System.out.println("Library will notify listeners... ");

        notifyListeners(e);

    }

    private void notifyListeners(Event e) {

        if (listeners != null) {
            listeners.stream().forEach(el -> el.onEvent(e));
        }
    }
}
