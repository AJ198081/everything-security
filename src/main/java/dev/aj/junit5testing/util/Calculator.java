package dev.aj.junit5testing.util;

public class Calculator {

    public int integerDivision(int a, int b) {
        return a/b;
    }

    public int integerMultiplication(int a, int b) {
        return a * b;
    }

    public double addition(double a, double b) {
        return a + b;
    }

    public int addition(int a, int b) {
        return a + b;

    }

    public int subtraction(int a, int b) {
        return a >= b ? a - b : b - a;
    }
}
