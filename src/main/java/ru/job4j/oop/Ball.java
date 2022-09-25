package ru.job4j.oop;

public class Ball {
    @SuppressWarnings("checkstyle:InnerAssignment")
    public void tryRun(boolean condition) {
        System.out.println((condition) ? "Колобок съеден" : "Колобок сбежал");
    }
}
