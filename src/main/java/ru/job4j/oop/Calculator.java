package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int summa(int sum) {
        return x + sum;
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
        return summa(abc) + multiply(abc) + minus(abc) + divide(abc);
    }

    public static void main(String[] args) {
        int rsl1 = summa(10);
        System.out.println(rsl1);
        Calculator calculator = new Calculator();
        int rsl2 = calculator.multiply(5);
        System.out.println(rsl2);
        int rsl3 = minus(11);
        System.out.println(rsl3);
        Calculator divide = new Calculator();
        int rsl4 = divide.divide(5);
        System.out.println(rsl4);
        Calculator allOperation = new Calculator();
        int rsl5 = allOperation.sumAllOperation(5);
        System.out.println(rsl5);
    }
}
