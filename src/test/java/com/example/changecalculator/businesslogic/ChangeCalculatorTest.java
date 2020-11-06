package com.example.changecalculator.businesslogic;

import com.example.changecalculator.model.ChangeItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangeCalculatorTest {

    @Test
    void workoutChangeInGbp() {
        ChangeCalculator changeCalculator = new ChangeCalculator("£");

        List<ChangeItem> results = changeCalculator.workoutChange(0.01, 999.99);
        assertEquals(results.size(), 12);

        assertEquals(results.get(0).quantity, 19);
        assertEquals(results.get(0).bankNoteOrCoin.getValue(), 50.0);

        assertEquals(results.get(1).quantity, 2);
        assertEquals(results.get(1).bankNoteOrCoin.getValue(), 20.0);

        assertEquals(results.get(2).quantity, 0);
        assertEquals(results.get(2).bankNoteOrCoin.getValue(), 10.0);

        assertEquals(results.get(3).quantity, 1);
        assertEquals(results.get(3).bankNoteOrCoin.getValue(), 5.0);

        assertEquals(results.get(4).quantity, 2);
        assertEquals(results.get(4).bankNoteOrCoin.getValue(), 2.0);

        assertEquals(results.get(5).quantity, 0);
        assertEquals(results.get(5).bankNoteOrCoin.getValue(), 1.0);

        assertEquals(results.get(6).quantity, 1);
        assertEquals(results.get(6).bankNoteOrCoin.getValue(), 0.5);

        assertEquals(results.get(7).quantity, 2);
        assertEquals(results.get(7).bankNoteOrCoin.getValue(), 0.2);

        assertEquals(results.get(8).quantity, 0);
        assertEquals(results.get(8).bankNoteOrCoin.getValue(), 0.1);

        assertEquals(results.get(9).quantity, 1);
        assertEquals(results.get(9).bankNoteOrCoin.getValue(), 0.05);

        assertEquals(results.get(10).quantity, 1);
        assertEquals(results.get(10).bankNoteOrCoin.getValue(), 0.02);

        assertEquals(results.get(11).quantity, 1);
        assertEquals(results.get(11).bankNoteOrCoin.getValue(), 0.01);

    }

    @Test
    void workoutChangeInUsd() {
        ChangeCalculator changeCalculator = new ChangeCalculator("$");

        List<ChangeItem> results = changeCalculator.workoutChange(0.01, 999.99);
        assertEquals(results.size(), 10);

        assertEquals(results.get(0).quantity, 9);
        assertEquals(results.get(0).bankNoteOrCoin.getValue(), 100.0);

        assertEquals(results.get(1).quantity, 1);
        assertEquals(results.get(1).bankNoteOrCoin.getValue(), 50.0);

        assertEquals(results.get(2).quantity, 2);
        assertEquals(results.get(2).bankNoteOrCoin.getValue(), 20.0);

        assertEquals(results.get(3).quantity, 0);
        assertEquals(results.get(3).bankNoteOrCoin.getValue(), 10.0);

        assertEquals(results.get(4).quantity, 1);
        assertEquals(results.get(4).bankNoteOrCoin.getValue(), 5.0);

        assertEquals(results.get(5).quantity, 4);
        assertEquals(results.get(5).bankNoteOrCoin.getValue(), 1.0);

        assertEquals(results.get(6).quantity, 3);
        assertEquals(results.get(6).bankNoteOrCoin.getValue(), 0.25);

        assertEquals(results.get(7).quantity, 2);
        assertEquals(results.get(7).bankNoteOrCoin.getValue(), 0.1);

        assertEquals(results.get(8).quantity, 0);
        assertEquals(results.get(8).bankNoteOrCoin.getValue(), 0.05);

        assertEquals(results.get(9).quantity, 3);
        assertEquals(results.get(9).bankNoteOrCoin.getValue(), 0.01);

    }
}