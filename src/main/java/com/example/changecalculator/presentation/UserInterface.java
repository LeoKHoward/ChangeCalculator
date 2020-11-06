package com.example.changecalculator.presentation;

import com.example.changecalculator.businesslogic.ChangeCalculator;
import com.example.changecalculator.model.ChangeItem;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public void run() {
        double totalCost;
        double moneyPaid;

        // Ask what currency the user is paying in
        System.out.println("\nWill you be purchasing something with £ or $: ");

        // Enter currency
        String currency = enterCurrency();

        // Check for unknown currency type
        unknownCurrency(currency);

        // Ask what how much the purchase costs
        System.out.println("\nHow much does the purchase cost: ");

        // Input cost and check it is correct type (double)
        totalCost = inputValue();

        // Ask how much the customer pays with
        System.out.println("\nHow much does the customer pay with: ");

        // Input amount paid and check it is correct type (double)
        moneyPaid = inputValue();

        // Work out if money given is less/equal/more than money owed
        chooseCorrectResponse(totalCost, moneyPaid, currency);

    }

    public void chooseCorrectResponse(double totalCost, double moneyPaid, String currency) {
        if (moneyPaid == totalCost) {
            System.out.println("\nNo change required");

        } else if (moneyPaid >= totalCost) {
            ChangeCalculator changeCalculator = new ChangeCalculator(currency);

            calculateChangeInCorrectCurrency(totalCost, moneyPaid, currency);

            List<ChangeItem> results = changeCalculator.workoutChange(totalCost, moneyPaid);
            for (ChangeItem result : results) {
                System.out.println(result.quantity + result.bankNoteOrCoin.getDescription());

            }

        } else {
            System.out.println("\nNot enough money you cheap bastard!");
        }
    }

    public void calculateChangeInCorrectCurrency(double totalCost, double moneyPaid, String currency) {
        if (currency.equals("£")) {
            System.out.println("\nYour change will be: £" + (moneyPaid - totalCost));

        } else {
            System.out.println("\nYour change will be: $" + (moneyPaid - totalCost));
        }
    }

    public String enterCurrency() {
        Scanner inputScanner = new Scanner(System.in);

        return inputScanner.next();
    }


    public double inputValue() {
        Scanner inputScanner = new Scanner(System.in);

        if (!inputScanner.hasNextDouble()) {
            throw new IllegalArgumentException("Please enter a correct value!");
        }
        return inputScanner.nextDouble();
    }


    public void unknownCurrency(String currency) {
        if ((!currency.equals("£")) && (!currency.equals("$"))) {
            throw new IllegalArgumentException("Invalid currency type entered!");
        }
    }
}
