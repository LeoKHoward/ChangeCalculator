package com.example.changecalculator.model;

public class BankNoteOrCoin {
    private double value;
    private String description;

    public BankNoteOrCoin(double value, String description) {
        this.value = value;
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
