package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void when52To34Then2dot82() {
        Point a = new Point(5, 2);
        Point b = new Point(3, 4);
        double out = a.distance(b);
        double expected = 2.82;
        assertThat(out).isEqualTo(expected, offset(0.01));
    }

    @Test
    void when05To33Then3dot60() {
        Point a = new Point(0, 5);
        Point b = new Point(3, 3);
        double out = a.distance(b);
        double expected = 3.60;
        assertThat(out).isEqualTo(expected, offset(0.01));
    }

    @Test
    void when34To52Then10() {
        Point a = new Point(3, -4);
        Point b = new Point(-5, 2);
        double out = a.distance(b);
        double expected = 10;
        assertThat(out).isEqualTo(expected);
    }
}