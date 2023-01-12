package ru.job4j.stream.mapto;

import java.util.List;
import java.util.stream.IntStream;

public class MapToObjExample {
    public static void main(String[] args) {
        List<String> list = IntStream.rangeClosed(1, 5)
                .mapToObj(String::valueOf)
                .toList();
        System.out.println(list);
    }
}