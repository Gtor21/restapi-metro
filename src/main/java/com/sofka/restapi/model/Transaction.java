package com.sofka.restapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Setter
@Getter
@Document(collection = "transactions")
public class Transaction {

    // Getters y setters
    @Id
    private String transactionId;
    private LocalDateTime timestamp;
    private String deviceNumber;
    private String userId;
    private String geoPosition;
    // Asegúrate de tener este método
    private double amount;

    // Constructor
    public Transaction() {
    }

    public Transaction(String transactionId, LocalDateTime timestamp, String deviceNumber,
                       String userId, String geoPosition, double amount) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.deviceNumber = deviceNumber;
        this.userId = userId;
        this.geoPosition = geoPosition;
        this.amount = amount;
    }

}
