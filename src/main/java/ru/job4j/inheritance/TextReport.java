package ru.job4j.inheritance;

public class TextReport {
    String ln = System.lineSeparator();

    public String generate(String name, String body) {
        return name + ln + body;
    }
}
