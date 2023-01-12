package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> rsl = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(rsl);
    }
}
