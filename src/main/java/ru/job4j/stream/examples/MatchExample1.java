package ru.job4j.stream.examples;

import java.util.Arrays;
import java.util.List;

public class MatchExample1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .anyMatch(e -> e.endsWith("е"));
        System.out.println(rsl);
    }
}
