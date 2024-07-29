package com.sofka.restapi.repository;

import com.sofka.restapi.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
