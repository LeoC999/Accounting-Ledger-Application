package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Legar {
    public static void legartime(Scanner transationlog) throws IOException {
        System.out.println("Welcome to your Legar.");
        System.out.println("To start select some more options");
        System.out.println("Enter (A)ll to see all of your interactions: ");
        System.out.println("Enter (D)eposit's to see only your deposits: ");
        System.out.println("Enter (P)ayments to see only what you've spent: ");
        System.out.println("Enter (R)eports to see custom searches: ");

        String legarletter =  transationlog.next();

        if (legarletter.equalsIgnoreCase("A")) {
            Scanner legarreader =new Scanner( new File("transactions.csv"));
            legarreader.nextLine();

            while(legarreader.hasNextLine()) {
                String legar = legarreader.nextLine();
                System.out.println(legar);

            }
            legarreader.close();
        }
        else if (legarletter.equalsIgnoreCase("D")) {
            Scanner legarreader =new Scanner( new File("transactions.csv"));
            legarreader.nextLine();
            while(legarreader.hasNextLine()) {
                String legar = legarreader.nextLine();
                System.out.println(legar);
            }
            legarreader.close();

        }

        else if (legarletter.equalsIgnoreCase("P")) {
            Scanner legarreader =new Scanner( new File("transactions.csv"));
            legarreader.nextLine();
            while(legarreader.hasNextLine()) {
                String legar = legarreader.nextLine();
                System.out.println(legar);
            }
            legarreader.close();
        }
        else if (legarletter.equalsIgnoreCase("R")) {
      Reports.reportactions(transationlog);


        }

    }

}
