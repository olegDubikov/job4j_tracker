package ru.job4j.stream.agregatmethod;

import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }
}
