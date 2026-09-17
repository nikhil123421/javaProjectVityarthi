package com.tracker.service;

import com.tracker.model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FinanceManager {
    private List<Transaction> transactions;
    private final String dataFilePath = "transactions.csv";

    public FinanceManager() {
        transactions = new ArrayList<>();
        loadData();
    }

    public void addTransaction(double amount, String type, String description) {
        // generate a short ID for display
        String id = UUID.randomUUID().toString().substring(0, 6);
        Transaction t = new Transaction(id, LocalDate.now(), amount, type, description);
        transactions.add(t);
        saveData();
        System.out.println("Transaction added successfully with ID: " + id);
    }

    public void removeTransaction(String id) {
        boolean removed = transactions.removeIf(t -> t.getId().equals(id));
        if (removed) {
            saveData();
            System.out.println("Transaction " + id + " removed successfully.");
        } else {
            System.out.println("Transaction with ID " + id + " not found.");
        }
    }

    public void viewAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println(String.format("%-8s | %-12s | %-9s | %-7s | %s", "ID", "Date", "Amount", "Type", "Description"));
        System.out.println("---------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.println(t.toString());
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void viewSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("INCOME")) {
                totalIncome += t.getAmount();
            } else if (t.getType().equalsIgnoreCase("EXPENSE")) {
                totalExpense += t.getAmount();
            }
        }

        double balance = totalIncome - totalExpense;

        System.out.println("--- Financial Summary ---");
        System.out.println("Total Income : $" + String.format("%.2f", totalIncome));
        System.out.println("Total Expense: $" + String.format("%.2f", totalExpense));
        System.out.println("Net Balance  : $" + String.format("%.2f", balance));
        System.out.println("-------------------------");
    }

    private void loadData() {
        File file = new File(dataFilePath);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Transaction t = Transaction.fromCSV(line);
                if (t != null) {
                    transactions.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))) {
            for (Transaction t : transactions) {
                writer.println(t.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
