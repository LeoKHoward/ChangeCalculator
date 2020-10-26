package com.example.changecalculator;

public interface ChangeCalculator {

    static void workoutChangeInGbp(double totalCostGbp, double moneyPaidGbp) {
        double changeGbp = moneyPaidGbp - totalCostGbp;

        if (moneyPaidGbp == totalCostGbp) {
            System.out.println("\nNo change required");

        } else if (moneyPaidGbp >= totalCostGbp) {
            System.out.println("\nYour change will be: £" + ((moneyPaidGbp - totalCostGbp) / 100));

            ChangeCalculatorApplication.BankNoteOrCoin[] gbpBankNotesOrCoins = new ChangeCalculatorApplication.BankNoteOrCoin[]{
                    new ChangeCalculatorApplication.BankNoteOrCoin(50, " £50 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(20, " £20 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(10, " £10 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(5, " £5 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(2, " £2 coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(1, " £1 coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.5, " 50p coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.2, " 20p coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.1, " 10p coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.05, " 5p coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.02, " 2p coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.01, " 1p coin(s)")
            };

            ChangeCalculatorApplication.bankNoteOrCoin(changeGbp, gbpBankNotesOrCoins);

        } else {
            System.out.println("\nNot enough money you cheap bastard!");
        }
    }

    static void workoutChangeInUsd(double totalCostUsd, double moneyPaidUsd) {
        double changeUsd = moneyPaidUsd - totalCostUsd;

        if (moneyPaidUsd == totalCostUsd) {
            System.out.println("\nNo change required");

        } else if (moneyPaidUsd >= totalCostUsd) {
            System.out.println("\nYour change will be: $" + ((moneyPaidUsd - totalCostUsd) / 100));

            ChangeCalculatorApplication.BankNoteOrCoin[] usdBankNotesOrCoins = new ChangeCalculatorApplication.BankNoteOrCoin[]{
                    new ChangeCalculatorApplication.BankNoteOrCoin(100, " $100 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(50, " $50 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(20, " $20 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(10, " $10 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(5, " $5 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(1, " $1 note(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.25, " quarter coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.1, " dime coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.05, " nickel coin(s)"),
                    new ChangeCalculatorApplication.BankNoteOrCoin(0.01, " one cent coin(s)")
            };

            ChangeCalculatorApplication.bankNoteOrCoin(changeUsd, usdBankNotesOrCoins);

        } else {
            System.out.println("\nNot enough money you cheap bastard!");
        }
    }
}
