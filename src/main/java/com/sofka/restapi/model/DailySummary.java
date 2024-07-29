package com.sofka.restapi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "daily_summaries")
public class DailySummary {

    @Id
    private LocalDate date;
    private double totalAmount;

    public DailySummary(LocalDate date, double totalAmount) {
        this.date = date;
        this.totalAmount = totalAmount;
    }
}
