package ru.job4j.stream.agregatmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());
    }
}