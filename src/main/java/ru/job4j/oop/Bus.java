package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по асфальту");
    }

    @Override
    public void psg() {
        int passenger = 43;
        System.out.println(passenger + " пассажира");
    }
}
