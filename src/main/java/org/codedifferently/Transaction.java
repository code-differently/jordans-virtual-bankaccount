package org.codedifferently;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    private double runningBalance;

    public Transaction(String type, double amount, String description, double runningBalance) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.runningBalance = runningBalance;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s: $%.2f - %s | Balance: $%.2f",
                timestamp.format(fmt), type, amount, description, runningBalance);
    }
}