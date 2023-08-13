package com.toolRental.helper;

public class PrintHelper {
    public static void displayMainMenu() {
        System.out.println("\n\nMain Menu:");
        System.out.println("| 1. Display Rental Tools Checkout Menu");
        System.out.println("| 2. Rental Tool Checkout");
        System.out.println("| 3. Exit");
    }
    public static void displayCheckoutMenu() {
        System.out.println("\n\nRental Tools Checkout Menu:");
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");
        System.out.println("|  Tool Code  |  Tool Type  |  Brand  |  Daily Charge  |  Weekday Charge  |  Weekend Charge  |  Holiday Charge  |");
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");
        System.out.println("|     CHNS    |  Chainsaw   |  Stihl  |      $1.99     |        Yes       |        Yes       |         No       |");
        System.out.println("|     LADW    |  Ladder     |  Werner |      $1.49     |        Yes       |        No        |         Yes      |");
        System.out.println("|     JAKD    |  Jackhammer |  DeWalt |      $2.99     |        Yes       |        No        |         No       |");
        System.out.println("|     JAKR    |  Jackhammer |  Ridgid |      $2.99     |        Yes       |        No        |         No       |");
        System.out.println("|---------------------------------------------------------------------------------------------------------------|");
    }
}
