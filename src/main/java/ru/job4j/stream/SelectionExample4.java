package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample4 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String rsl = strings
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(rsl);
    }
}
