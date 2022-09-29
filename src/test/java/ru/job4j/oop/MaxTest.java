package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxTest {

    @Test
    void whenMax1To2Then2() {
        int one = 1;
        int two = 2;
        int out = Max.max(one, two);
        int expected = 2;
        assertThat(out).isEqualTo(expected);
    }

    @Test
    void whenMax1To2To3Then3() {
        int one = 4;
        int two = 2;
        int three = 3;
        int out = Max.max(one, two, three);
        int expected = 4;
        assertThat(out).isEqualTo(expected);
    }

    @Test
    void whenMax1To2To3To4Then4() {
        int one = 1;
        int two = 7;
        int three = 3;
        int four = 4;
        int out = Max.max(one, two, three, four);
        int expected = 7;
        assertThat(out).isEqualTo(expected);
    }
}