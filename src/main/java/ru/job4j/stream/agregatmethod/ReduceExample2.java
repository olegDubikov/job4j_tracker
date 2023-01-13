package ru.job4j.stream.agregatmethod;

import java.util.Arrays;
import java.util.List;

public class ReduceExample2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream()
                .reduce(5, (a, b) -> a + b);
        System.out.println(sum);
    }
}
