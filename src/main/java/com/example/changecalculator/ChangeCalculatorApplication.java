package com.example.changecalculator;

import com.example.changecalculator.presentation.InputAndOutputToScreen;
import com.example.changecalculator.presentation.UserInterface;

public class ChangeCalculatorApplication {

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface(new InputAndOutputToScreen());
        userInterface.run();

    }

}
