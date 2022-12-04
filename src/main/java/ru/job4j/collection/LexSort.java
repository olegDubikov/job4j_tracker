package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] strLeft = left.split("\\.");
        String[] strRight = right.split("\\.");
        int numLeft = Integer.parseInt(strLeft[0]);
        int numRight = Integer.parseInt(strRight[0]);
        return Integer.compare(numLeft, numRight);
    }
}