package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sdkvm@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("erlow@yandex.ru", "Popov Dmitry");
        map.put("sdkvm@mail.ru", "Sidorov Pavel");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}