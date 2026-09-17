package com.tracker;

import com.tracker.service.FinanceManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Personal Finance Tracker");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Financial Summary");
            System.out.println("5. Remove a Transaction");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addTransactionHelper(scanner, manager, "INCOME");
                    break;
                case "2":
                    addTransactionHelper(scanner, manager, "EXPENSE");
                    break;
                case "3":
                    manager.viewAllTransactions();
                    break;
                case "4":
                    manager.viewSummary();
                    break;
                case "5":
                    System.out.print("Enter transaction ID to remove: ");
                    String id = scanner.nextLine().trim();
                    manager.removeTransaction(id);
                    break;
                case "6":
                    System.out.println("Exiting... Have a good day!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addTransactionHelper(Scanner scanner, FinanceManager manager, String type) {
        try {
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                return;
            }
            System.out.print("Enter description: ");
            String description = scanner.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty.");
                return;
            }
            manager.addTransaction(amount, type, description);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid number.");
        }
    }
}
