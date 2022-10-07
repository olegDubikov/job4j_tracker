package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        LocalDateTime item = item1.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String current = item.format(formatter);
        System.out.println(current);
        System.out.println(item2);
    }
}
