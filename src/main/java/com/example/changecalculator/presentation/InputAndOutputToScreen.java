package com.example.changecalculator.presentation;

public class InputAndOutputToScreen implements InputAndOutput {

    @Override
    public void output(String textToOutput) {
        System.out.println(textToOutput);
    }
}
