package com.sofka.restapi.repository;

import com.sofka.restapi.model.DailySummary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface DailySummaryRepository extends MongoRepository<DailySummary, LocalDate> {
}
