package ru.job4j.max.inheritance;

public class Engineer extends Profession {
    private int experience;

    public Engineer(int experience, boolean degree) {
        super(degree);
        this.experience = experience;
    }
}
