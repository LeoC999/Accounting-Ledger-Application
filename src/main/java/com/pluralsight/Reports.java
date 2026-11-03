package com.pluralsight;

import java.time.Month;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Reports {
    public static void reportactions(Scanner transationlog) throws IOException {
        System.out.println("Welcome to the reports here are the options.");
        System.out.println("Enter (1) for a month to date records ");
        System.out.println("Enter (2) for a previous month records ");
        System.out.println("Enter (3) for a year records ");
        System.out.println("Enter (4) for a precious year records ");
        System.out.println("Enter (5) for vendor records ");
        System.out.println("Enter (0) to go back to home screen ");
        System.out.println("\nEnter number here: ");

        String letter = transationlog.next();

        if (letter.equalsIgnoreCase("1")) {
            currentMonth();
        } else if (letter.equalsIgnoreCase("2")) {
            previousMonth();
        }
        else if (letter.equalsIgnoreCase("3")) {
            currentYear();
        }
        else if (letter.equalsIgnoreCase("4")) {
            previousYear();
        }
    }

    public static void currentMonth() throws FileNotFoundException {
        LocalDate thismonth = LocalDate.now();
        LocalDate dayofthismonth = thismonth.withDayOfMonth(1);
        Scanner filescanner = new Scanner(new File("transactions.csv"));

        while (filescanner.hasNextLine()) {
            String line = filescanner.nextLine();
            String[] choice1 = line.split("\\|");
            LocalDate localDateMonth = LocalDate.parse(choice1[0]);

            if (localDateMonth.isAfter(dayofthismonth.minusDays(1)) && localDateMonth.isBefore(thismonth.plusDays(1))) {
                System.out.println(line);
            }
        }
    }

    public static void previousMonth() throws FileNotFoundException {
        LocalDate previousmonth = LocalDate.now().minusMonths(1);

        Scanner filescanner = new Scanner(new File("transactions.csv"));

        while (filescanner.hasNextLine()) {
            String line = filescanner.nextLine();
            String[] choice2 = line.split("\\|");
            LocalDate localDateMonth = LocalDate.parse(choice2[0]);

            if (localDateMonth.getMonth() == previousmonth.getMonth() && localDateMonth.getYear() == previousmonth.getYear()) {
                System.out.println(line);
            }
        }

    }

    public static void currentYear() throws FileNotFoundException {
      int currentYear = LocalDate.now().getYear();
        Scanner filescanner = new Scanner(new File("transactions.csv"));
        while (filescanner.hasNextLine()) {
            String line = filescanner.nextLine();
            String[] choice =  line.split("\\|");
            LocalDate localDateYear = LocalDate.parse(choice[0]);
            if (localDateYear.getYear() == currentYear) {
                System.out.println(line);
            }
        }
    }
public static void previousYear() throws FileNotFoundException {

        int previousYear = LocalDate.now().minusYears(1).getYear();

        Scanner fileScanner = new Scanner(new File("transactions.csv"));

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();
            String[] choice1 = line.split("\\|");

            LocalDate transactionDate = LocalDate.parse(choice1[0]);

            if (transactionDate.getYear() == previousYear) {

                System.out.println(line);
            }
        }
    }
}








}



