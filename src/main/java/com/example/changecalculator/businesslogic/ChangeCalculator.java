package com.example.changecalculator.businesslogic;

import com.example.changecalculator.model.BankNoteOrCoin;
import com.example.changecalculator.model.ChangeItem;

import java.util.LinkedList;
import java.util.List;

public class ChangeCalculator {

    BankNoteOrCoin[] bankNotesOrCoins;


    public ChangeCalculator(String currency) {
        if (currency.equals("£")) {
            bankNotesOrCoins = new BankNoteOrCoin[]{
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

        } else {
            bankNotesOrCoins = new BankNoteOrCoin[]{
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

        }

    }

    public List<ChangeItem> workoutChange(double totalCost, double moneyPaid) {
        totalCost = totalCost * 100;
        moneyPaid = moneyPaid * 100;

        double changeTotal = moneyPaid - totalCost;

        return bankNoteOrCoin(changeTotal);


    }

    private List<ChangeItem> bankNoteOrCoin(double change) {
        List<ChangeItem> result = new LinkedList<>();


        for (BankNoteOrCoin bankNoteOrCoin : bankNotesOrCoins) {
            int noteOrCoinTotal = (int) ((int) change / bankNoteOrCoin.getValue());
            if (noteOrCoinTotal > 0) {
                change = change % (int) (bankNoteOrCoin.getValue() * 100);

                ChangeItem changeItem = new ChangeItem();
                changeItem.quantity = noteOrCoinTotal / 100;
                changeItem.bankNoteOrCoin = bankNoteOrCoin;

                result.add(changeItem);
            }
        }
        return result;
    }
}
