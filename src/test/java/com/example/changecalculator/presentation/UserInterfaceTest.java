package com.example.changecalculator.presentation;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserInterfaceTest {

    @Test
    void testUnknownCurrency() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                    UserInterface wrongCurrency = new UserInterface(new InputAndOutputToScreen());
                    wrongCurrency.unknownCurrency("!");
                }
        );

        assertEquals("Invalid currency type entered!", exception.getMessage());
    }


    @Test
    public void testOutputMessageIfPaymentEqualsCost() {

        InputAndOutput mockIo = mock(InputAndOutput.class);

        UserInterface exactMoneyGiven = new UserInterface(mockIo);

        String expectedOutput = "\nNo change required";

        exactMoneyGiven.chooseCorrectResponse(10.0, 10.0, "£");

        verify(mockIo).output(expectedOutput);
    }


    @Test
    public void testOutputMessageIfPaymentIsLowerThanCost() {

        InputAndOutput mockIo = mock(InputAndOutput.class);

        UserInterface lowerPaymentGiven = new UserInterface(mockIo);

        String expectedOutput = "\nNot enough money you cheap bastard!";

        lowerPaymentGiven.chooseCorrectResponse(10.0, 5.0, "£");

        verify(mockIo).output(expectedOutput);


    }

    @Test
    public void testCalculateChangeInCorrectCurrencyGbp() {

        InputAndOutput mockIo = mock(InputAndOutput.class);

        UserInterface produceChangeMessageForGbp = new UserInterface(mockIo);

        String expectedOutput = "\nYour change will be: £9.98";

        produceChangeMessageForGbp.calculateChangeInCorrectCurrency(0.01, 9.99, "£");

        verify(mockIo).output(expectedOutput);


    }

    @Test
    public void testCalculateChangeInCorrectCurrencyUsd() {

        InputAndOutput mockIo = mock(InputAndOutput.class);

        UserInterface produceChangeMessageForUsd = new UserInterface(mockIo);

        String expectedOutput = "\nYour change will be: $9.98";

        produceChangeMessageForUsd.calculateChangeInCorrectCurrency(0.01, 9.99, "$");

        verify(mockIo).output(expectedOutput);

    }


}