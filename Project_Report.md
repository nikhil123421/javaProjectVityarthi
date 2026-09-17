# Project Report: Personal Finance Tracker

## 1. Project Title and Description
**Title**: Personal Finance Tracker
**Description**: 
The Personal Finance Tracker is a console-based Java application designed to help individuals monitor their financial health. It enables users to seamlessly log their daily income and expenses, providing a clear overview of their net balance and total expenditure. The primary goal of this project is to implement core Object-Oriented Programming (OOP) concepts in Java alongside essential data persistence mechanisms without relying on external databases.

## 2. Motivation and Domain Justification
Managing personal finances is a common challenge for students and working professionals alike. Developing a system to track income and expenses provides real-world utility while serving as an excellent platform to demonstrate programming logic, control flows, state management, and file I/O operations. The console-based approach ensures that the application remains lightweight, fast, and universally accessible via standard terminal environments.

## 3. Technology Stack
- **Programming Language**: Java (JDK 8 or above)
- **Paradigm**: Object-Oriented Programming (OOP)
- **Data Storage**: Plain-text CSV (Comma-Separated Values) for local data persistence.
- **Execution Environment**: CLI (Command Line Interface)

## 4. Architecture and Design
The project is structured using standard Java package conventions for modularity:
- **`com.tracker.model`**: Contains the `Transaction` entity class. This class defines the data structure for a single transaction (ID, Date, Amount, Type, Description) and handles CSV serialization/deserialization logic.
- **`com.tracker.service`**: Contains the `FinanceManager` class which acts as the business logic layer. It manages a collection (List) of transactions, performs calculations (net balance), and handles reading from and writing to the `transactions.csv` file.
- **`com.tracker`**: Contains the `Main` application driver class. It is responsible for user interaction, input parsing, and routing commands to the `FinanceManager`.

## 5. Key Features Implemented
1. **Transaction Logging**: Users can enter numeric amounts and string descriptions to log financial activities.
2. **Dynamic ID Generation**: Generates brief, unique identifiers for individual transactions using `UUID`.
3. **Data Persistence**: Uses `BufferedReader` and `PrintWriter` for continuous saving and loading of application state across sessions, ensuring no data loss upon exit.
4. **Summary Aggregation**: Computes totals on-the-fly to summarize net financial posture.
5. **Robust Error Handling**: Handles cases like invalid numeric inputs (`NumberFormatException`) and missing files gracefully without crashing the application.

## 6. Execution Instructions
The project is strictly executable via the command line. Users can clone the repository, compile the source code using the standard `javac` command, and execute using the `java` interpreter. Step-by-step commands for both Windows and Unix systems are detailed in the `README.md`.

## 7. Future Enhancements
- Implementing categorized spending (e.g., Groceries, Rent, Entertainment).
- Adding graphical charts/visualizations in the console using ASCII art.
- Filtering transactions by month or date ranges.
