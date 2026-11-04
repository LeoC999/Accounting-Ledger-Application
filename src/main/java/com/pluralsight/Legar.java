package com.pluralsight;
import java.io.*;

import java.util.Scanner;

public class Legar {
    public static void legartime(Scanner transationlog) throws IOException {
        boolean legartimerun = true;
        while (legartimerun) {


            System.out.println("\nWelcome to your Legar\n.");
            System.out.println("To start select some more options");
            System.out.println("Enter (A)ll to see all of your interactions ");
            System.out.println("Enter (D)eposit's to see only your deposits ");
            System.out.println("Enter (P)ayments to see only what you've spent ");
            System.out.println("Enter (R)eports to see custom searches ");
            System.out.println("Enter (B)ack to go back to menu");
            System.out.println("\nEnter Letter Here:");


            String legarletter = transationlog.next();

            if (legarletter.equalsIgnoreCase("A")) {
                Scanner legarreader = new Scanner(new File("transactions.csv"));
                legarreader.nextLine();

                while (legarreader.hasNextLine()) {
                    String legar = legarreader.nextLine();
                    System.out.println(legar);

                }
                legarreader.close();

            } else if (legarletter.equalsIgnoreCase("D")) {
                Scanner legarreader = new Scanner(new File("transactions.csv"));

                legarreader.nextLine();

                while (legarreader.hasNextLine()) {

                    String legar = legarreader.nextLine();

                    if(legar.trim().isEmpty()){continue;}

                    String[] legarstring = legar.split("\\|");
                    if (legarstring.length < 5) {
                        continue;
                    }

                   double amount = Double.parseDouble(legarstring[4]);
                   if (amount > 0){
                       System.out.println(String.join("|", legarstring));
                   }
                }
                legarreader.close();

            } else if (legarletter.equalsIgnoreCase("P")) {
                Scanner legarreader = new Scanner(new File("transactions.csv"));

                legarreader.nextLine();

                while (legarreader.hasNextLine()) {

                    String legar = legarreader.nextLine();
                    if(legar.trim().isEmpty()){continue;}

                    String[]  legarstring = legar.split("\\|");

                    if (legarstring.length < 5) {
                        continue;}

                    double amount = Double.parseDouble(legarstring[4]);

                    if (amount < 0){
                        System.out.println(String.join("|", legarstring));
                    }
                }
                legarreader.close();

            } else if (legarletter.equalsIgnoreCase("R")) {
                Reports.reportactions(transationlog);


            }
            else if (legarletter.equalsIgnoreCase("B")) {
                legartimerun = false;
            }

        }
    }

}
