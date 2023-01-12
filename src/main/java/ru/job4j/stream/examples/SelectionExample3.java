package ru.job4j.stream.examples;

import java.util.Arrays;
import java.util.List;

public class SelectionExample3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String rsl = strings
                .stream()
                .skip(2)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(rsl);
    }
}