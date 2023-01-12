package ru.job4j.stream.agregatmethod;

import java.util.Arrays;
import java.util.List;

public class CountExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        long sum = nums.stream()
                .filter(el -> el % 2 == 0)
                .count();
        System.out.println(sum);
    }
}