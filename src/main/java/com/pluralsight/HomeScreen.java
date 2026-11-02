package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HomeScreen {
    public static void homescreen(Scanner transationlog) throws IOException {
        System.out.println("Welcome to the Accounting Ledger App");
        System.out.println("To get us started select from a few options");
        System.out.println("Enter (D)eposit to input your deposit information: ");
        System.out.println("Enter (P)ayment (Debit) information:");
        System.out.println("Enter (L)egar to display your legar: ");
        String letter = transationlog.next();

        if (letter.equalsIgnoreCase("D")) {
            transationlog.nextLine(); // clears leftover newline

            System.out.print("Description: ");
            String description = transationlog.nextLine();

            System.out.print("Vendor: ");
            String vendor = transationlog.nextLine();

            System.out.print("Amount: ");
            double amount = Double.parseDouble(transationlog.nextLine());

            FileWriter writer = new FileWriter("transactions.csv", true);

            writer.write(description + "|" +
                    vendor + "|" +
                    amount + "\n");

            writer.close();

            System.out.println("Deposit saved!");
        }
        else if (letter.equalsIgnoreCase("P")) {
            transationlog.nextLine();
            System.out.print("Description: ");
            String description = transationlog.nextLine();
            System.out.print("Vendor: ");
            String vendor = transationlog.nextLine();
            System.out.print("Amount: ");
            double amount = Double.parseDouble(transationlog.nextLine());
            amount = -amount;
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(description + "|" +
                    vendor + "|" +
                    amount + "\n");
            writer.close();
            System.out.println("Deposit saved!");
        }
    }

        }








