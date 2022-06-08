package com.example.primeNumbers.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberControllerTest {

    @Test
    void oneIsNotAPrimeNumber() {
        var valueOne = PrimeNumberController.isPrime(1);
        assertFalse(valueOne);
    }

    @Test
    void minusOneIsNotAPrimeNumber() {
        var valueMinusOne = PrimeNumberController.isPrime(-1);
        assertFalse(valueMinusOne);
    }

    @Test
    void minusOneThousandIsNotAPrimeNumber() {
        var valueMinusOneThousand = PrimeNumberController.isPrime(-1000);
        assertFalse(valueMinusOneThousand);
    }

    @Test
    void twoIsAPrimeNumber() {
        var valueTwo= PrimeNumberController.isPrime(2);
        assertTrue(valueTwo);
    }

    @Test
    void ninetyEightIsNotAPrimeNumber() {
        var valueNinetyEight = PrimeNumberController.isPrime(98);
        assertFalse(valueNinetyEight);
    }

    @Test
    void sevenThousandNineHundredAndNineteenIsAPrimeNumber() {
        var valueSevenThousandNineHundredAndNineteen = PrimeNumberController.isPrime(7919);
        assertTrue(valueSevenThousandNineHundredAndNineteen);
    }

    @Test
    void sendValueOneAndOneIsReturned() {
        var valueOne = PrimeNumberController.primeNumbers(1);
        assertEquals(valueOne.getNumber(), 1);
    }

    @Test
    void sendValueOneAndEmptyListIsReturned() {
        var emptyList = PrimeNumberController.primeNumbers(1);
        assertTrue(emptyList.getPrimeNumbers().isEmpty());
    }

    @Test
    void sizeOfListReturnedIsTwenty() {
        var twentyIsReturned = PrimeNumberController.primeNumbers(71);
        assertEquals(twentyIsReturned.getPrimeNumbers().size(), 20);
    }
}