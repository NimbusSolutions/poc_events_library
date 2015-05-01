package com.nimbus.poc.events.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by Kye on 30/04/15.
 */
@Configuration
@EnableJms
public class EventConfiguration {

    @Bean
    public JmsListenerContainerFactory<?> topicJmsContainerFactory(ConnectionFactory connectionFactory) {

        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);

        return factory;
    }



}
