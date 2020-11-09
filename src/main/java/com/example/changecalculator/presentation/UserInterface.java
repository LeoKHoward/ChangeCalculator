package com.example.changecalculator.presentation;

import com.example.changecalculator.businesslogic.ChangeCalculator;
import com.example.changecalculator.model.ChangeItem;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final InputAndOutput io;
    private Scanner inputScanner = new Scanner(System.in);

    public UserInterface(InputAndOutput io) {
        this.io = io;
    }

    public void run() {
        double totalCost;
        double moneyPaid;

        // Ask what currency the user is paying in
        io.output("\nWill you be purchasing something with £ or $: ");

        // Enter currency
        String currency = inputScanner.next();

        // Check for unknown currency type
        unknownCurrency(currency);

        // Ask what how much the purchase costs
        io.output("\nHow much does the purchase cost: ");

        // Input cost and check it is correct type (double)
        totalCost = inputValue();

        // Ask how much the customer pays with
        io.output("\nHow much does the customer pay with: ");

        // Input amount paid and check it is correct type (double)
        moneyPaid = inputValue();

        // Work out if money given is less/equal/more than money owed
        chooseCorrectResponse(totalCost, moneyPaid, currency);

    }

    public void chooseCorrectResponse(double totalCost, double moneyPaid, String currency) {

        if (moneyPaid == totalCost) {
            io.output("\nNo change required");

        } else if (moneyPaid > totalCost) {
            ChangeCalculator changeCalculator = new ChangeCalculator(currency);

            calculateChangeInCorrectCurrency(totalCost, moneyPaid, currency);

            List<ChangeItem> results = changeCalculator.workoutChange(totalCost, moneyPaid);
            for (ChangeItem result : results) {
                io.output(result.quantity + result.bankNoteOrCoin.getDescription());

            }

        } else {
            io.output("\nNot enough money you cheap bastard!");
        }
    }

    public void calculateChangeInCorrectCurrency(double totalCost, double moneyPaid, String currency) {

        if (currency.equals("£")) {
            io.output("\nYour change will be: £" + (moneyPaid - totalCost));

        } else {
            io.output("\nYour change will be: $" + (moneyPaid - totalCost));
        }
    }


    public double inputValue() {

        while (!inputScanner.hasNextDouble()) {
            io.output("\nPlease enter a correct value!");
            inputScanner.next();
        }
        return inputScanner.nextDouble();
    }


    public void unknownCurrency(String currency) {

        if ((!currency.equals("£")) && (!currency.equals("$"))) {
            throw new IllegalArgumentException("Invalid currency type entered!");
        }
    }
}
