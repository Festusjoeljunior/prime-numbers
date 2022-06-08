package com.example.primeNumbers;

import java.util.List;

public class Response {
    private int number;
    private List<Integer> primeNumbers;

    public Response(int number, List<Integer> primeNumbers) {
        this.number = number;
        this.primeNumbers = primeNumbers;
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }
}
