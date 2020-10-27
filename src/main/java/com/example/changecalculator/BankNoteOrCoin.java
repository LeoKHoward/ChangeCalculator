package com.example.changecalculator;

public class BankNoteOrCoin {

    private double value;
    private String description;

    public BankNoteOrCoin(double value, String description) {
        this.value = value;
        this.description = description;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
