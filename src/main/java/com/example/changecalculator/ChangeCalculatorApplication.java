package com.example.changecalculator;

import java.util.Scanner;

public class ChangeCalculatorApplication implements ChangeCalculator {

    public static void main(String[] args) throws Exception {

        new Scanner(System.in);

        new ChangeCalculatorService();

    }

    public static class BankNoteOrCoin {
        public final double value;
        public final String description;

        public BankNoteOrCoin(double value, String description) {
            this.value = value;
            this.description = description;
        }
    }

    static void bankNoteOrCoin(double changeUsd, BankNoteOrCoin[] usdBankNotesOrCoins) {

        for (BankNoteOrCoin bankNoteOrCoin : usdBankNotesOrCoins) {
            int noteOrCoinTotal = (int) ((int) changeUsd / bankNoteOrCoin.value);
            if (noteOrCoinTotal > 0) {
                changeUsd = changeUsd % (int) (bankNoteOrCoin.value * 100);
                System.out.println(noteOrCoinTotal / 100 + bankNoteOrCoin.description);
            }
        }
    }
}
