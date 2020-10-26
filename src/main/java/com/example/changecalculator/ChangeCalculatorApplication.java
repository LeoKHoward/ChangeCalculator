package com.example.changecalculator;

import java.util.Scanner;

public class ChangeCalculatorApplication {

    public static void main(String[] args) throws Exception {
        String currency;

        Scanner inputScanner = new Scanner(System.in);

        // Choose currency
        currency = getCurrencyType(inputScanner);

        purchaseQuestions(currency, inputScanner);

    }

    private static String getCurrencyType(Scanner inputScanner) {
        String currency;
        System.out.println("\nWill you be purchasing something with £ or $: ");

        currency = inputScanner.next();

        return currency;
    }

    private static void purchaseQuestions(String currency, Scanner inputScanner) throws Exception {
        double totalCost;
        double moneyPaid;

        System.out.println("\nHow much does the purchase cost: ");
        totalCost = inputScanner.nextDouble() * 100;

        System.out.println("\nHow much does the customer pay with: ");
        moneyPaid = inputScanner.nextDouble() * 100;

        if (currency.equals("£")) {
            workoutChangeInGbp(totalCost, moneyPaid);

        } else if (currency.equals("$")) {
            workoutChangeInUsd(totalCost, moneyPaid);

        } else {
            throw new Exception("Invalid currency type entered!");
        }
    }

    public static class BankNoteOrCoin {
        public final double value;
        public final String description;


        public BankNoteOrCoin(double value, String description) {
            this.value = value;
            this.description = description;
        }
    }

    public static void workoutChangeInGbp(double totalCostGbp, double moneyPaidGbp) {
        double changeGbp = moneyPaidGbp - totalCostGbp;

        if (moneyPaidGbp == totalCostGbp) {
            System.out.println("\nNo change required");

        } else if (moneyPaidGbp >= totalCostGbp) {
            System.out.println("\nYour change will be: £" + ((moneyPaidGbp - totalCostGbp) / 100));

            BankNoteOrCoin[] gbpBankNotesOrCoins = new BankNoteOrCoin[]{
                    new BankNoteOrCoin(50, " £50 note(s)"),
                    new BankNoteOrCoin(20, " £20 note(s)"),
                    new BankNoteOrCoin(10, " £10 note(s)"),
                    new BankNoteOrCoin(5, " £5 note(s)"),
                    new BankNoteOrCoin(2, " £2 coin(s)"),
                    new BankNoteOrCoin(1, " £1 coin(s)"),
                    new BankNoteOrCoin(0.5, " 50p coin(s)"),
                    new BankNoteOrCoin(0.2, " 20p coin(s)"),
                    new BankNoteOrCoin(0.1, " 10p coin(s)"),
                    new BankNoteOrCoin(0.05, " 5p coin(s)"),
                    new BankNoteOrCoin(0.02, " 2p coin(s)"),
                    new BankNoteOrCoin(0.01, " 1p coin(s)")

            };

            bankNoteOrCoin(changeGbp, gbpBankNotesOrCoins);

        } else {
            System.out.println("\nNot enough money you cheap bastard!");
        }

    }

    public static void workoutChangeInUsd(double totalCostUsd, double moneyPaidUsd) {
        double changeUsd = moneyPaidUsd - totalCostUsd;

        if (moneyPaidUsd == totalCostUsd) {
            System.out.println("\nNo change required");

        } else if (moneyPaidUsd >= totalCostUsd) {
            System.out.println("\nYour change will be: $" + ((moneyPaidUsd - totalCostUsd) / 100));

            BankNoteOrCoin[] usdBankNotesOrCoins = new BankNoteOrCoin[]{
                    new BankNoteOrCoin(100, " $100 note(s)"),
                    new BankNoteOrCoin(50, " $50 note(s)"),
                    new BankNoteOrCoin(20, " $20 note(s)"),
                    new BankNoteOrCoin(10, " $10 note(s)"),
                    new BankNoteOrCoin(5, " $5 note(s)"),
                    new BankNoteOrCoin(1, " $1 note(s)"),
                    new BankNoteOrCoin(0.25, " quarter coin(s)"),
                    new BankNoteOrCoin(0.1, " dime coin(s)"),
                    new BankNoteOrCoin(0.05, " nickel coin(s)"),
                    new BankNoteOrCoin(0.01, " one cent coin(s)")

            };

            bankNoteOrCoin(changeUsd, usdBankNotesOrCoins);

        } else {
            System.out.println("\nNot enough money you cheap bastard!");
        }

    }

    private static void bankNoteOrCoin(double changeUsd, BankNoteOrCoin[] usdBankNotesOrCoins) {

        for (BankNoteOrCoin bankNoteOrCoin : usdBankNotesOrCoins) {
            int noteTotal = (int) ((int) changeUsd / bankNoteOrCoin.value);
            if (noteTotal > 0) {
                changeUsd = changeUsd % (int) (bankNoteOrCoin.value * 100);
                System.out.println(noteTotal / 100 + bankNoteOrCoin.description);
            }
        }
    }
}
