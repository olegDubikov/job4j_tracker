package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        var s1 = o1.split("/");
        var s2 = o2.split("/");
        var rsl = s2[0].compareTo(s1[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}