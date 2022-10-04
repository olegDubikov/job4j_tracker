package ru.job4j.max.inheritance;

public class JSONReport extends TextReport {

    private static final String LN = System.lineSeparator();

    @Override
    public String generate(String name, String body) {
        return "{" + LN + "\t\"name\" : " + "\"" + name + "\"" + ","
                + LN + "\t\"body\" : " + "\"" + body + "\"" + LN + "}";
    }
}
