package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Item(int id) {
        this.id = id;
    }

    Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}