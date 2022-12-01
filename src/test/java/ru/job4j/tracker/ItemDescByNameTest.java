package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void whenListFromLargestToSmallest() {
        List<Item> items = Arrays.asList(
                new Item("John"),
                new Item("Stepan"),
                new Item("Fedor")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Stepan"),
                new Item("John"),
                new Item("Fedor")
        );
        assertThat(items).isEqualTo(expected);
    }
}
