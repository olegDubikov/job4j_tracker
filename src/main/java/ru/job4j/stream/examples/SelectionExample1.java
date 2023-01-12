package ru.job4j.stream.examples;

import java.util.Arrays;
import java.util.List;

public class SelectionExample1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .limit(3)
                .toList();
        System.out.println(rsl);
    }
}