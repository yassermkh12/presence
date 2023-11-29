package com.example.presence.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "YM-Queues", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Message reçu du topic : " + message);
    }
}
