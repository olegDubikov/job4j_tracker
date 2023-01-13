package ru.job4j.stream.agregatmethod;

import java.util.List;
import java.util.Optional;

public class ReduceExample1 {
    public static void main(String[] args) {
        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> sum = nums.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(sum.get());
    }
}