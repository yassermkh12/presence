package com.example.presence.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMsg(String destination, String message){
        jmsTemplate.convertAndSend(destination,message);
        System.out.println("message envoyer a : "+ destination + ", "+ message);
    }
}
