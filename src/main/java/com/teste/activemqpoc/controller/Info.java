package com.teste.activemqpoc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.teste.activemqpoc.consumer.ConsumerActiveMQQueue;

@Component("info")
public class Info implements HttpRequestHandler {

    @Autowired
    private ConsumerActiveMQQueue queue;

    @Value("${ENV_NAME}")
    private String environment;

    @Override
    public void handleRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
    IOException {
        String mensagem = this.queue.getLastMessage();
        response.getOutputStream().print(mensagem == null ? this.environment + ":Sem mensagens." : mensagem);
    }
}
