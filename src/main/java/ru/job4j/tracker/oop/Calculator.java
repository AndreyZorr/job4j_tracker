package ru.job4j.tracker.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int b) {
        return x * b;
    }

    public static int minus(int c) {
        return c - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int f) {
        return sum(f) + minus(f) + divide(f) + multiply(f);
    }

    public static void main(String[] args) {
        int rsl = sum(1);
        int rsl1 = minus(1);
        Calculator calculator = new Calculator();
        int rsl2 = calculator.multiply(1);
        int rsl3 = calculator.divide(1);
        int rsl4 = calculator.sumAllOperation(rsl + rsl1 + rsl3);
        System.out.println(rsl);
        System.out.println(rsl1);
        System.out.println(rsl2);
        System.out.println(rsl3);
        System.out.println(rsl4);
    }
}
