package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> name = a -> a.getName().contains(key);
        Predicate<Person> surname = a -> a.getSurname().contains(key);
        Predicate<Person> phone = a -> a.getPhone().contains(key);
        Predicate<Person> address = a -> a.getAddress().contains(key);
        var combine = name.or(surname).or(phone).or(address);
        for (var rsl : persons) {
            if (combine.test(rsl)) {
                result.add(rsl);
            }
        }
        return result;
    }
}
