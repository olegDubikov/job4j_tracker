package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4);
        List<Integer> positive = numbers.stream().filter(num -> num > 0).toList();
        positive.forEach(System.out::println);
    }
}