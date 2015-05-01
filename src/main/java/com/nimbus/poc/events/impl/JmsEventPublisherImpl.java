package com.nimbus.poc.events.impl;

import com.nimbus.poc.events.Event;
import com.nimbus.poc.events.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Kye on 01/05/15.
 */
@Component
public class JmsEventPublisherImpl implements EventPublisher {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsEventPublisherImpl(JmsTemplate jmsTemplate) {

        jmsTemplate.setPubSubDomain(true);
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publish(final Event event){

        jmsTemplate.send("microservice.event", new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage(event.getMessage());
            }
        });

        // TODO this would be the way to do it passing the entire event
      //  jmsTemplate.convertAndSend("microservice.event", event);
    }
}
