package com.example.primeNumbers.controller;

import com.example.primeNumbers.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PrimeNumberController {

    @GetMapping(value = "/primeNumbers/{number}")
    public static Response primeNumbers(@PathVariable int number) {
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return new Response(number, primeNumbers);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
