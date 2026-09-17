package com.tracker.model;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private LocalDate date;
    private double amount;
    private String type;
    private String description;

    public Transaction(String id, LocalDate date, double amount, String type, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getDescription() { return description; }

    public String toCSV() {
        return id + "," + date.toString() + "," + amount + "," + type + "," + description;
    }

    public static Transaction fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", 5);
        if (parts.length < 5) return null;
        return new Transaction(
            parts[0],
            LocalDate.parse(parts[1]),
            Double.parseDouble(parts[2]),
            parts[3],
            parts[4]
        );
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-12s | %-9.2f | %-7s | %s", id, date.toString(), amount, type, description);
    }
}
