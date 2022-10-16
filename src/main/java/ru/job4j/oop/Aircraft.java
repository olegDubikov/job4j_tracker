package ru.job4j.oop;

public class Aircraft implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает в воздушном пространстве");
    }

    @Override
    public void psg() {
        int passenger = 147;
        System.out.println(passenger + " пассажиров");
    }
}
