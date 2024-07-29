package com.sofka.restapi.service;

import com.sofka.restapi.model.DailySummary;
import com.sofka.restapi.model.Transaction;
import com.sofka.restapi.repository.DailySummaryRepository;
import com.sofka.restapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class DailySummaryService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DailySummaryRepository dailySummaryRepository;

    @Scheduled(cron = "0 0 0 * * *")  // Ejecutar todos los días a medianoche
    public void generateDailySummary() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        List<Transaction> transactions = transactionRepository.findByTimestampBetween(startOfDay, endOfDay);
        double totalAmount = transactions.stream().mapToDouble(Transaction::getAmount).sum();

        // Guardar el resumen diario en MongoDB
        DailySummary dailySummary = new DailySummary(today, totalAmount);
        dailySummaryRepository.save(dailySummary);
    }
}
