package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phoneDictionary.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFind() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534123", "Bryansk")
        );
        var persons = phoneDictionary.find("Lipetsk");
        assertThat(persons.isEmpty()).isTrue();
    }
}