package com.example.changecalculator.presentation;

import com.example.changecalculator.ChangeCalculatorApplication;
import com.example.changecalculator.businesslogic.ChangeCalculator;
import org.junit.jupiter.api.Test;
import org.xmlunit.builder.Input;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    @Test
    void unknownCurrency() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                    UserInterface wrongCurrency = new UserInterface();
                    wrongCurrency.unknownCurrency("!");
                }
        );

        assertEquals("Invalid currency type entered!", exception.getMessage());
    }

    @Test
    void nonDoubleValue() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                    UserInterface nonDoubleValue = new UserInterface();
                    nonDoubleValue.inputValue();
                }
        );

        assertEquals("Please enter a correct value!", exception.getMessage());
    }

    @Test
    void outputMessageIfMoneyGivenEqualsMoneyOwed() {
        UserInterface exactMoneyGiven = new UserInterface();

        ChangeCalculator result = exactMoneyGiven.chooseCorrectResponse(10.0, 10.0, "£");

        assertEquals();

    }

    @Test
    public void testMessageIfPaymentIsLowerThanCost() {
        ChangeCalculatorApplication sameAmount = new ChangeCalculatorApplication();
        ChangeCalculatorApplication.workoutChangeInGbp(50, 50);
        assertEquals(sameAmount.equals());


    }



}