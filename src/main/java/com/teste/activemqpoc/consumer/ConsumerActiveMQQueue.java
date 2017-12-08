package com.teste.activemqpoc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("queueListener")
public class ConsumerActiveMQQueue {
    
    private String lastMessage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerActiveMQQueue.class);

    public void onMessage(String message) {
        lastMessage = message;
        LOGGER.info("received message='{}'", message);
    }
    
    /**
     * Método get do atributo lastMessage
     * @return O valor do atributo lastMessage
     */
    public String getLastMessage() {
        return lastMessage;
    }
}
