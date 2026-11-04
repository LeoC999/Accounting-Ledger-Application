package com.pluralsight;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;


public class Reports {
    public static void reportactions(Scanner transationlog) throws IOException {
        boolean reported = true;
        while (reported) {

            System.out.println("\nWelcome to the reports here are the options\n");
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
            } else if (letter.equalsIgnoreCase("3")) {
                currentYear();
            } else if (letter.equalsIgnoreCase("4")) {
                previousYear();
            } else if (letter.equalsIgnoreCase("5")) {
                vendorInfo(transationlog);
            } else if (letter.equalsIgnoreCase("0")) {
             reported = false;

            }
        }
    }

        public static void currentMonth () throws FileNotFoundException {
            LocalDate thismonth = LocalDate.now();
            LocalDate dayofthismonth = thismonth.withDayOfMonth(1);
            Scanner filescanner = new Scanner(new File("transactions.csv"));

            while (filescanner.hasNextLine()) {
                String line = filescanner.nextLine().trim();

                if(line.trim().isEmpty()){continue;}


                String[] choice1 = line.split("\\|");

                if (choice1.length < 5) {
                    continue;
                }

                LocalDate localDateMonth = LocalDate.parse(choice1[0]);

                if (localDateMonth.isAfter(dayofthismonth.minusDays(1)) && localDateMonth.isBefore(thismonth.plusDays(1))) {
                    System.out.println(line);

                }
            }
            filescanner.close();
        }

        public static void previousMonth () throws FileNotFoundException {
            LocalDate previousmonth = LocalDate.now().minusMonths(1);
            boolean found = false;

            Scanner filescanner = new Scanner(new File("transactions.csv"));

            while (filescanner.hasNextLine()) {

                String line = filescanner.nextLine();
                if(line.trim().isEmpty()){continue;}

                String[] choice2 = line.split("\\|");

                if (choice2.length < 5) {
                    continue;}

                LocalDate localDateMonth = LocalDate.parse(choice2[0]);

                if (localDateMonth.getMonth() == previousmonth.getMonth() && localDateMonth.getYear() == previousmonth.getYear()) {
                    System.out.println(line);
                    found = true;
                }


            }

            if (!found) {
                System.out.println("No recoders of previous month found");
            }
            filescanner.close();
        }


        public static void currentYear () throws FileNotFoundException {
        int currentYear = LocalDate.now().getYear();

        Scanner filescanner = new Scanner(new File("transactions.csv"));

        while (filescanner.hasNextLine()) {
                String line = filescanner.nextLine();

                if(line.trim().isEmpty()){continue;}

                String[] choice = line.split("\\|");

                if (choice.length < 5) {
                    continue;
                }

                LocalDate localDateYear = LocalDate.parse(choice[0]);

                if (localDateYear.getYear() == currentYear) {
                    System.out.println(line);
                }
            }
            filescanner.close();
        }
        public static void previousYear () throws FileNotFoundException {

            int previousYear = LocalDate.now().minusYears(1).getYear();

            boolean previousYearFound = false;

            Scanner fileScanner = new Scanner(new File("transactions.csv"));

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                if(line.trim().isEmpty()){continue;}

                String[] choice1 = line.split("\\|");

                if (choice1.length < 5) {
                    continue;
                }

                LocalDate transactionDate = LocalDate.parse(choice1[0]);

                if (transactionDate.getYear() == previousYear) {

                    System.out.println(line);
                }

            }
            if (!previousYearFound) {
                System.out.println("No recoders of previous year found");
            }

            fileScanner.close();
        }
        public static void vendorInfo (Scanner transationlog) throws FileNotFoundException {

            transationlog.nextLine();
            System.out.println("Enter Vendor Name: ");
            String vendorname = transationlog.nextLine();

            Scanner filescanner = new Scanner(new File("transactions.csv"));
            boolean vendorfound = false;

            while (filescanner.hasNextLine()) {

                String line = filescanner.nextLine();

                if(line.trim().isEmpty()){continue;}

                String[] choice = line.split("\\|");

                if (choice.length < 5) {
                    continue;
                }

                if (choice[3].equalsIgnoreCase(vendorname)) {
                    System.out.println(line);
                    vendorfound = true;
                }

            }
            if (!vendorfound) {
                System.out.println("No vendors found");
            }
            filescanner.close();
        }
    }






