package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double out = triangle.area();
        double expected = 8;
        assertThat(out).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when42and61and04Then16() {
        Point a = new Point(-4, 2);
        Point b = new Point(6, -1);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double out = triangle.area();
        double expected = 16;
        assertThat(out).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when20and20and53Then1() {
        Point a = new Point(2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(5, 3);
        Triangle triangle = new Triangle(a, b, c);
        double out = triangle.area();
        double expected = -1;
        assertThat(out).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when22and11and10Then1dot5() {
        Point a = new Point(2, 2);
        Point b = new Point(-1, -1);
        Point c = new Point(-1, 0);
        Triangle triangle = new Triangle(a, b, c);
        double out = triangle.area();
        double expected = 1.5;
        assertThat(out).isCloseTo(expected, offset(0.001));
    }
}