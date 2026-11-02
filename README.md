Accounting Ledger Application
Description
The Accounting Ledger Application is a Java console program that allows users to record financial transactions and store them in a transaction file. Users can create deposits, record payments, and view transaction history through a menu-driven interface.

Features
Add Deposits
Record Payments (Debits)
View Ledger Entries
Read Transactions from a CSV File
Save Transactions to a CSV File
Menu-Based Navigation
Screens
Home Screen
D) Add Deposit
P) Make Payment
L) View Ledger
Q) Quit
Ledger Screen
View All Entries
View Deposits Only
View Payments Only
Return to Home Screen
Technologies Used
Java
Scanner
FileWriter
BufferedWriter
LocalDate
LocalTime
File Format
Transactions are stored in:

transactions.csv

Format:

date|time|description|vendor|amount

Example:

2026-11-02|18:30:25|Paycheck|Employer|1500.00

How to Run
Open the project in IntelliJ.
Run Accounting.java.
Follow the menu prompts.
Transactions will be saved to transactions.csv.
Author
Leo Castillo
