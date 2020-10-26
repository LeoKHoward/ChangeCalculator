package com.example.changecalculator;

import java.util.Scanner;

public class ChangeCalculatorService {

    public ChangeCalculatorService() throws Exception {
        double totalCost;
        double moneyPaid;

        System.out.println("\nWill you be purchasing something with £ or $: ");

        Scanner inputScanner = new Scanner(System.in);

        String currency = inputScanner.next();

        if ((!currency.equals("£")) && (!currency.equals("$"))) {
            throw new Exception("Invalid currency type entered!");
        }

        System.out.println("\nHow much does the purchase cost: ");
        totalCost = inputScanner.nextDouble() * 100;

        System.out.println("\nHow much does the customer pay with: ");
        moneyPaid = inputScanner.nextDouble() * 100;

        if (currency.equals("£")) {
            ChangeCalculator.workoutChangeInGbp(totalCost, moneyPaid);

        } else {
            ChangeCalculator.workoutChangeInUsd(totalCost, moneyPaid);
        }

    }
}
