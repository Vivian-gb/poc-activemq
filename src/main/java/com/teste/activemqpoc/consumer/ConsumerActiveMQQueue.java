package com.teste.activemqpoc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("queueListener")
public class ConsumerActiveMQQueue {

    private String lastMessage;

    @Value("${ENV_NAME}")
    private String environment;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerActiveMQQueue.class);

    public void onMessage(final String message) {
        this.lastMessage = message;
        LOGGER.info("received message='{}', env: {}", message, this.environment);
    }

    /**
     * Método get do atributo lastMessage
     * @return O valor do atributo lastMessage
     */
    public String getLastMessage() {
        return this.lastMessage;
    }
}
