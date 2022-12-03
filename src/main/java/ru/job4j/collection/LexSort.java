package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String strLeft = left.replaceAll("[^0-9]", "");
        String strRight = right.replaceAll("[^0-9]", "");
        int numLeft = Integer.parseInt(strLeft);
        int numRight = Integer.parseInt(strRight);
        return Integer.compare(numLeft, numRight);
    }
}