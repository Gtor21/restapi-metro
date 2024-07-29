package com.sofka.restapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.restapi.config.RabbitMQConfig;
import com.sofka.restapi.model.Transaction;
import com.sofka.restapi.repository.TransactionRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public Transaction createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        rabbitTemplate.convertAndSend(RabbitMQConfig.TRANSACTION_QUEUE, savedTransaction);
        System.out.println("Mensaje enviado a RabbitMQ: " + savedTransaction);
        return savedTransaction;
    }

}
