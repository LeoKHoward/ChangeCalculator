package com.example.changecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeCalculatorApplicationTest {
    private static final double totalCostGbp = 99.99;
    private static final double moneyPaidGbp = 333.33;

    private ChangeCalculatorApplication changeCalculatorApplication = new ChangeCalculatorApplication();


    // Expected change = 233.34
    // 4 £50
    // 1 £20
    // 1 £10
    // 1 £2
    // 1 £1
    // 1 20p
    // 1 10p
    // 2 2p


    @Test
    public void testCorrectChangeTotalInGbp() {
        double totalCostGbp = 99.99;
        double moneyPaidGbp = 333.33;
        double changeGbp = 233.34;


    }

    @Test
    public void testCorrectNumberOfFiftiesInGbp() {
        ChangeCalculatorApplication changeCalculatorApplication = new ChangeCalculatorApplication();

        int fiftyNoteTotal = 4;
        assertEquals(fiftyNoteTotal, changeCalculatorApplication(4));

    }

    @Test
    public void testCorrectNumberOfTwentiesInGbp() {

        int twentyNoteTotal = 1;
        assertEquals(twentyNoteTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOfTensInGbp() {

        int tenNoteTotal = 1;
        assertEquals(tenNoteTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOf2PoundCoins() {

        int twoPoundCoinTotal = 1;
        assertEquals(twoPoundCoinTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOf1PoundCoins() {

        int onePoundCoinTotal = 1;
        assertEquals(onePoundCoinTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOf20p() {

        int twentyPenceCoinTotal = 1;
        assertEquals(twentyPenceCoinTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOf10p() {

        int tenPenceCoinTotal = 1;
        assertEquals(tenPenceCoinTotal, changeCalculatorApplication(1));

    }

    @Test
    public void testCorrectNumberOf2p() {

        int twoPenceCoinTotal = 2;
        assertEquals(twoPenceCoinTotal, changeCalculatorApplication(2));

    }

    @Test
    public void testDontThrowErrorKnownCharacterEnteredAsCurrency() {

        ChangeCalculatorApplication testChangeCalculatorApplication = new ChangeCalculatorApplication();

        String goodCharacter = "£";
        !assertEquals(goodCharacter, testChangeCalculatorApplication.getCurrencyType().toString("!"));


    }

    @Test
    public void testThrowErrorIfUnknownCharacterEnteredAsCurrency() throws Exception {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Invalid currency type entered!");
        });

        ChangeCalculatorApplication badCurrency = new ChangeCalculatorApplication();
        badCurrency.getCurrencyType().;

        assertEquals("Invalid currency type entered!", exception.getMessage());


    }


    @Test
    public void testThrowErrorIfAnythingOtherThanNumberOrDecimalEntered() {


    }

    @Test
    public void testMessageIfPaymentIsLowerThanCost() {
        ChangeCalculatorApplication sameAmount = new ChangeCalculatorApplication();
        ChangeCalculatorApplication.workoutChangeInGbp(50, 50);
        assertEquals(sameAmount.equals());


    }

    @Test
    public void testMessageIfPaymentIsSameAsCost() {


    }
}