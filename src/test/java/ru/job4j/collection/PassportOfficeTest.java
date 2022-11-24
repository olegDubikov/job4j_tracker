package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestNotAddMap() {
        Citizen citizen = new Citizen("qwerty", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen citizen1 = new Citizen("qwerty", "Ivan Ivanov");
        assertThat(office.add(citizen1)).isFalse();
    }
}