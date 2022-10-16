package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] trans = new Vehicle[]{aircraft, train, bus};
        for (Vehicle trs : trans) {
            trs.move();
            trs.psg();
            System.out.println();
        }
    }
}
