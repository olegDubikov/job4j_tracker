package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int number) {
        return x + number;
    }

    public int multiply(int times) {
        return x * times;
    }

    public static int minus(int min) {
        return min - x;
    }

    public int divide(int del) {
        return del / x;
    }

    public int sumAllOperation(int abc) {
        return sum(abc) + multiply(abc) + minus(abc) + divide(abc);
    }

    public static void main(String[] args) {
        int rsl1 = sum(10);
        int rsl3 = minus(11);
        Calculator calculator = new Calculator();
        int rsl2 = calculator.multiply(5);
        int rsl4 = calculator.divide(5);
        int rsl5 = calculator.sumAllOperation(5);
        System.out.println(rsl1);
        System.out.println(rsl2);
        System.out.println(rsl3);
        System.out.println(rsl4);
        System.out.println(rsl5);
    }
}
