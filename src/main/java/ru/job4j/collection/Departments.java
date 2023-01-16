package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        var linkedHashSet = new LinkedHashSet<String>();
        for (var value : deps) {
            String start = "";
            for (var el : value.split("/")) {
                start += start.isEmpty() ? el : ("/" + el);
                linkedHashSet.add(start);
            }
        }
        return new ArrayList<>(linkedHashSet);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}