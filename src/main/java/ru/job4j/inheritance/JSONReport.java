package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return "{" + ln + "\t\"name\" : " + "\"" + name + "\"" + "," + ln
                + "\t\"body\" : " + "\"" + body + "\"" + ln + "}";
    }
}
